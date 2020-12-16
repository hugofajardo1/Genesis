package com.ar.genesis.sistema.ficha.usecase;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import com.ar.genesis.sistema.localidad.core.domain.Localidad;
import com.ar.genesis.sistema.provincia.core.domain.Provincia;
import com.ar.genesis.sistema.tipoiva.core.domain.TipoIva;
import com.ar.genesis.sistema.ficha.core.exception.FichaExisteException;
import com.ar.genesis.sistema.ficha.core.repository.IFichaRepository;
import com.ar.genesis.sistema.ficha.core.usecase.FichaCrearUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class FichaCrearUseCaseTest {
    @Mock
    IFichaRepository miFichaRepository;

    @Test
    void crearFicha_FichaNoExiste_GuardaCorrectamente() throws FichaExisteException {
        Ficha unaFicha = Ficha.instancia(1, "Fajardo, Hugo", "Bs As 245", Localidad.instancia(1, "Chilecito"), Provincia.instancia(1, "La Rioja"), "3825416543", TipoIva.instancia(1, "Responsable Inscripto"), "20255071336", "B-00007-777", "Contacto: Fajardo");
        when(miFichaRepository.existeFicha("Fajardo, Hugo")).thenReturn(false);
        when(miFichaRepository.guardarFicha(unaFicha)).thenReturn(true);
        FichaCrearUseCase fichaCrearUseCase = new FichaCrearUseCase(miFichaRepository);
        boolean resultado = fichaCrearUseCase.crearFicha(unaFicha);
        Assertions.assertTrue(resultado);
    }
    @Test
    void crearFicha_FichaExiste_NoGuardaFicha() {
        Ficha unaFicha = Ficha.instancia(1, "Fajardo, Hugo", "Bs As 245", Localidad.instancia(1, "Chilecito"), Provincia.instancia(1, "La Rioja"), "3825416543", TipoIva.instancia(1, "Responsable Inscripto"), "20255071336", "B-00007-777", "Contacto: Fajardo");
        when(miFichaRepository.existeFicha("Fajardo, Hugo")).thenReturn(true);
        when(miFichaRepository.guardarFicha(unaFicha)).thenReturn(false);
        FichaCrearUseCase fichaCrearUseCase = new FichaCrearUseCase(miFichaRepository);
        Assertions.assertThrows(FichaExisteException.class, () -> fichaCrearUseCase.crearFicha(unaFicha));
    }
}