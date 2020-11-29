package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Ficha;
import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.core.exception.FichaExisteException;
import com.ar.genesis.sistema.core.repository.IFichaRepository;
import com.ar.genesis.sistema.core.usecase.ModificarFichaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class ModificarFichaUseCaseTest {
    @Mock
    IFichaRepository iFichaRepository;

    @Test
    void modificarFicha_FichaActualizadoCorrectamente() throws FichaExisteException {
        Ficha unaFicha = Ficha.instancia(1, "Fajardo, Hugo", "Bs As 245", "3825416543", TipoIva.instancia(1, "Responsable Inscripto"), "20255071336");
        when(iFichaRepository.existeFicha("Fajardo, Hugo")).thenReturn(false);
        when(iFichaRepository.guardarFicha(unaFicha)).thenReturn(true);
        ModificarFichaUseCase modificarFichaUseCase = new ModificarFichaUseCase(iFichaRepository);
        boolean resultado = modificarFichaUseCase.modificarFicha(unaFicha);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarFicha_HayConflictoFichaExiste_FichaNoActualiza() {
        Ficha unaFicha = Ficha.instancia(1, "Fajardo, Hugo", "Bs As 245", "3825416543", TipoIva.instancia(1, "Responsable Inscripto"), "20255071336");
        when(iFichaRepository.existeFicha("Fajardo, Hugo")).thenReturn(true);
        when(iFichaRepository.guardarFicha(unaFicha)).thenReturn(false);
        ModificarFichaUseCase modificarFichaUseCase = new ModificarFichaUseCase(iFichaRepository);
        Assertions.assertThrows(FichaExisteException.class, () -> modificarFichaUseCase.modificarFicha(unaFicha));
    }
}