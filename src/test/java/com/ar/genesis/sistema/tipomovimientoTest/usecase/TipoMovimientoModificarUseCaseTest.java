package com.ar.genesis.sistema.tipomovimientoTest.usecase;

import com.ar.genesis.sistema.tipomovimiento.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.tipomovimiento.core.exception.TipoMovimientoExisteException;
import com.ar.genesis.sistema.tipomovimiento.core.repository.ITipoMovimientoRepository;
import com.ar.genesis.sistema.tipomovimiento.core.usecase.TipoMovimientoModificarUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class TipoMovimientoModificarUseCaseTest {
    @Mock
    ITipoMovimientoRepository miTipoMovimientoRepository;
    @Test
    void modificarTipoMovimiento_TipoMovimientoActualizadoCorrectamente() throws TipoMovimientoExisteException {
        TipoMovimiento unTipoMovimiento = TipoMovimiento.instancia(1, "Factura A");
        when(miTipoMovimientoRepository.existeTipoMovimiento("Factura A")).thenReturn(false);
        when(miTipoMovimientoRepository.guardarTipoMovimiento(unTipoMovimiento)).thenReturn(true);
        TipoMovimientoModificarUseCase tipoMovimientoModificarUseCase = new TipoMovimientoModificarUseCase(miTipoMovimientoRepository);
        boolean resultado = tipoMovimientoModificarUseCase.modificarTipoMovimiento(unTipoMovimiento);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarTipoMovimiento_HayConflictoTipoMovimientoExiste_TipoMovimientoNoActualiza() {
        TipoMovimiento unTipoMovimiento = TipoMovimiento.instancia(1, "Factura A");
        when(miTipoMovimientoRepository.existeTipoMovimiento("Factura A")).thenReturn(true);
        when(miTipoMovimientoRepository.guardarTipoMovimiento(unTipoMovimiento)).thenReturn(false);
        TipoMovimientoModificarUseCase tipoMovimientoModificarUseCase = new TipoMovimientoModificarUseCase(miTipoMovimientoRepository);
        Assertions.assertThrows(TipoMovimientoExisteException.class, () -> tipoMovimientoModificarUseCase.modificarTipoMovimiento(unTipoMovimiento));
    }
}
