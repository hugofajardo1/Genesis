package com.ar.genesis.sistema.tipooperacionTest.usecase;

import com.ar.genesis.sistema.tipooperacion.core.domain.TipoOperacion;
import com.ar.genesis.sistema.tipooperacion.core.exception.TipoOperacionExisteException;
import com.ar.genesis.sistema.tipooperacion.core.repository.ITipoOperacionRepository;
import com.ar.genesis.sistema.tipooperacion.core.usecase.TipoOperacionCrearUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class TipoOperacionCrearUseCaseTest {
    @Mock
    ITipoOperacionRepository miTipoOperacionRepository;
    @Test
    void crearTipoOperacion_TipoOperacionNoExiste_GuardaCorrectamente() throws TipoOperacionExisteException {
        TipoOperacion unTipoOperacion = TipoOperacion.instancia(1, "Ventas");
        when(miTipoOperacionRepository.existeTipoOperacion("Ventas")).thenReturn(false);
        when(miTipoOperacionRepository.guardarTipoOperacion(unTipoOperacion)).thenReturn(true);
        TipoOperacionCrearUseCase tipoUnidadCrearUseCase = new TipoOperacionCrearUseCase(miTipoOperacionRepository);
        boolean resultado = tipoUnidadCrearUseCase.crearTipoOperacion(unTipoOperacion);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearTipoOperacion_TipoOperacionExiste_NoGuardaTipoOperacion() {
        TipoOperacion unTipoOperacion = TipoOperacion.instancia(1, "Ventas");
        when(miTipoOperacionRepository.existeTipoOperacion("Ventas")).thenReturn(true);
        when(miTipoOperacionRepository.guardarTipoOperacion(unTipoOperacion)).thenReturn(false);
        TipoOperacionCrearUseCase tipoUnidadCrearUseCase = new TipoOperacionCrearUseCase(miTipoOperacionRepository);
        Assertions.assertThrows(TipoOperacionExisteException.class, () -> tipoUnidadCrearUseCase.crearTipoOperacion(unTipoOperacion));
    }
}
