package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.core.exception.TipoMovimientoExisteException;
import com.ar.genesis.sistema.core.repository.ITipoMovimientoRepository;
import com.ar.genesis.sistema.core.usecase.ModificarTipoMovimientoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class ModificarTipoMovimientoUseCaseTest {
    @Mock
    ITipoMovimientoRepository iTipoMovimientoRepository;
    @Test
    void modificarTipoMovimiento_TipoMovimientoActualizadoCorrectamente() throws TipoMovimientoExisteException {
        TipoMovimiento unTipoMovimiento = TipoMovimiento.instancia(1, "Factura A");
        when(iTipoMovimientoRepository.existeTipoMovimiento("Factura A")).thenReturn(false);
        when(iTipoMovimientoRepository.guardarTipoMovimiento(unTipoMovimiento)).thenReturn(true);
        ModificarTipoMovimientoUseCase modificarTipoMovimientoUseCase = new ModificarTipoMovimientoUseCase(iTipoMovimientoRepository);
        boolean resultado = modificarTipoMovimientoUseCase.modificarTipoMovimiento(unTipoMovimiento);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarTipoMovimiento_HayConflictoTipoMovimientoExiste_TipoMovimientoNoActualiza() {
        TipoMovimiento unTipoMovimiento = TipoMovimiento.instancia(1, "Factura A");
        when(iTipoMovimientoRepository.existeTipoMovimiento("Factura A")).thenReturn(true);
        when(iTipoMovimientoRepository.guardarTipoMovimiento(unTipoMovimiento)).thenReturn(false);
        ModificarTipoMovimientoUseCase modificarTipoMovimientoUseCase = new ModificarTipoMovimientoUseCase(iTipoMovimientoRepository);
        Assertions.assertThrows(TipoMovimientoExisteException.class, () -> modificarTipoMovimientoUseCase.modificarTipoMovimiento(unTipoMovimiento));
    }
}
