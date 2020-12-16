package com.ar.genesis.sistema.tipomovimiento.usecase;

import com.ar.genesis.sistema.tipomovimiento.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.tipomovimiento.core.exception.TipoMovimientoExisteException;
import com.ar.genesis.sistema.tipomovimiento.core.repository.ITipoMovimientoRepository;
import com.ar.genesis.sistema.tipomovimiento.core.usecase.TipoMovimientoCrearUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class TipoMovimientoCrearUseCaseTest {
    @Mock
    ITipoMovimientoRepository miTipoMovimientoRepository;
    @Test
    void crearTipoMovimiento_TipoMovimientoNoExiste_GuardaCorrectamente() throws TipoMovimientoExisteException {
        TipoMovimiento unTipoMovimiento = TipoMovimiento.instancia(1, "Factura A");
        when(miTipoMovimientoRepository.existeTipoMovimiento("Factura A")).thenReturn(false);
        when(miTipoMovimientoRepository.guardarTipoMovimiento(unTipoMovimiento)).thenReturn(true);
        TipoMovimientoCrearUseCase tipoMovimientoCrearUseCase = new TipoMovimientoCrearUseCase(miTipoMovimientoRepository);
        boolean resultado = tipoMovimientoCrearUseCase.crearTipoMovimiento(unTipoMovimiento);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearTipoMovimiento_TipoMovimientoExiste_NoGuardaTipoMovimiento() {
        TipoMovimiento unTipoMovimiento = TipoMovimiento.instancia(1, "Factura A");
        when(miTipoMovimientoRepository.existeTipoMovimiento("Factura A")).thenReturn(true);
        when(miTipoMovimientoRepository.guardarTipoMovimiento(unTipoMovimiento)).thenReturn(false);
        TipoMovimientoCrearUseCase tipoMovimientoCrearUseCase = new TipoMovimientoCrearUseCase(miTipoMovimientoRepository);
        Assertions.assertThrows(TipoMovimientoExisteException.class, () -> tipoMovimientoCrearUseCase.crearTipoMovimiento(unTipoMovimiento));
    }
}
