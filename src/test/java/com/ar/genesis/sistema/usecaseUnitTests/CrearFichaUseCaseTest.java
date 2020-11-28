package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Ficha;
import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.core.exception.FichaExisteException;
import com.ar.genesis.sistema.core.repository.IFichaRepository;
import com.ar.genesis.sistema.core.usecase.CrearFichaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class CrearFichaUseCaseTest {
    @Mock
    IFichaRepository iFichaRepository;

    @Test
    void crearFicha_FichaNoExiste_GuardaCorrectamente() throws FichaExisteException {
        Ficha unaFicha = Ficha.instancia(1, "Fajardo, Hugo", "Bs As 245", "3825416543", TipoIva.instancia(1, "Responsable Inscripto"), "20255071336");
        when(iFichaRepository.existeFicha("Fajardo, Hugo")).thenReturn(false);
        when(iFichaRepository.guardarFicha(unaFicha)).thenReturn(true);
        CrearFichaUseCase crearFichaUseCase = new CrearFichaUseCase(iFichaRepository);
        boolean resultado = crearFichaUseCase.crearFicha(unaFicha);
        Assertions.assertTrue(resultado);
    }
    @Test
    void crearFicha_FichaExiste_NoGuardaFicha() {
        Ficha unaFicha = Ficha.instancia(1, "Fajardo, Hugo", "Bs As 245", "3825416543", TipoIva.instancia(1, "Responsable Inscripto"), "20255071336");
        when(iFichaRepository.existeFicha("Fajardo, Hugo")).thenReturn(true);
        when(iFichaRepository.guardarFicha(unaFicha)).thenReturn(false);
        CrearFichaUseCase crearFichaUseCase = new CrearFichaUseCase(iFichaRepository);
        Assertions.assertThrows(FichaExisteException.class, () -> crearFichaUseCase.crearFicha(unaFicha));
    }
}