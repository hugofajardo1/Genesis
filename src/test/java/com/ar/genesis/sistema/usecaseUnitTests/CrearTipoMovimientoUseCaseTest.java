package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.core.exception.TipoMovimientoExisteException;
import com.ar.genesis.sistema.core.repository.ITipoMovimientoRepository;
import com.ar.genesis.sistema.core.usecase.CrearTipoMovimientoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class CrearTipoMovimientoUseCaseTest {
    @Mock
    ITipoMovimientoRepository miTipoMovimientoRepository;
    @Test
    void crearTipoMovimiento_TipoMovimientoNoExiste_GuardaCorrectamente() throws TipoMovimientoExisteException {
        TipoMovimiento unTipoMovimiento = TipoMovimiento.instancia(1, "Factura A");
        when(miTipoMovimientoRepository.existeTipoMovimiento("Factura A")).thenReturn(false);
        when(miTipoMovimientoRepository.guardarTipoMovimiento(unTipoMovimiento)).thenReturn(true);
        CrearTipoMovimientoUseCase crearTipoMovimientoUseCase = new CrearTipoMovimientoUseCase(miTipoMovimientoRepository);
        boolean resultado = crearTipoMovimientoUseCase.crearTipoMovimiento(unTipoMovimiento);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearTipoMovimiento_TipoMovimientoExiste_NoGuardaTipoMovimiento() {
        TipoMovimiento unTipoMovimiento = TipoMovimiento.instancia(1, "Factura A");
        when(miTipoMovimientoRepository.existeTipoMovimiento("Factura A")).thenReturn(true);
        when(miTipoMovimientoRepository.guardarTipoMovimiento(unTipoMovimiento)).thenReturn(false);
        CrearTipoMovimientoUseCase crearTipoMovimientoUseCase = new CrearTipoMovimientoUseCase(miTipoMovimientoRepository);
        Assertions.assertThrows(TipoMovimientoExisteException.class, () -> crearTipoMovimientoUseCase.crearTipoMovimiento(unTipoMovimiento));
    }
}
