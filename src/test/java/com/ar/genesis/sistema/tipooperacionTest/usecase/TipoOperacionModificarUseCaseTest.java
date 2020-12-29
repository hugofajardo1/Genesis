package com.ar.genesis.sistema.tipooperacionTest.usecase;

import com.ar.genesis.sistema.tipooperacion.core.domain.TipoOperacion;
import com.ar.genesis.sistema.tipooperacion.core.exception.TipoOperacionExisteException;
import com.ar.genesis.sistema.tipooperacion.core.repository.ITipoOperacionRepository;
import com.ar.genesis.sistema.tipooperacion.core.usecase.TipoOperacionModificarUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class TipoOperacionModificarUseCaseTest {
    @Mock
    ITipoOperacionRepository miTipoOperacionRepository;
    @Test
    void modificarTipoOperacion_TipoOperacionActualizadoCorrectamente() throws TipoOperacionExisteException {
        TipoOperacion unTipoOperacion = TipoOperacion.instancia(1, "Venta");
        when(miTipoOperacionRepository.existeTipoOperacion("Venta")).thenReturn(false);
        when(miTipoOperacionRepository.guardarTipoOperacion(unTipoOperacion)).thenReturn(true);
        TipoOperacionModificarUseCase tipoOperacionModificarUseCase = new TipoOperacionModificarUseCase(miTipoOperacionRepository);
        boolean resultado = tipoOperacionModificarUseCase.modificarTipoOperacion(unTipoOperacion);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarTipoOperacion_HayConflictoTipoOperacionExiste_TipoOperacionNoActualiza() {
        TipoOperacion unTipoOperacion = TipoOperacion.instancia(1, "Venta");
        when(miTipoOperacionRepository.existeTipoOperacion("Venta")).thenReturn(true);
        when(miTipoOperacionRepository.guardarTipoOperacion(unTipoOperacion)).thenReturn(false);
        TipoOperacionModificarUseCase tipoOperacionModificarUseCase = new TipoOperacionModificarUseCase(miTipoOperacionRepository);
        Assertions.assertThrows(TipoOperacionExisteException.class, () -> tipoOperacionModificarUseCase.modificarTipoOperacion(unTipoOperacion));
    }
}
