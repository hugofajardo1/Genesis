package com.ar.genesis.sistema.tipomovimientoTest.usecase;

import com.ar.genesis.sistema.tipomovimiento.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.tipomovimiento.core.exception.TipoMovimientoNoExisteException;
import com.ar.genesis.sistema.tipomovimiento.core.repository.ITipoMovimientoObtenerPorIdRepository;
import com.ar.genesis.sistema.tipomovimiento.core.usecase.TipoMovimientoObtenerPorIdUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class TipoMovimientoObtenerPorIdUseCaseTest {
    @Mock
    ITipoMovimientoObtenerPorIdRepository miTipoMovimientoObtenerPorIdRepository;

    @Test
    public void obtenerTipoMovimientoPorId_devuelveTipoMovimiento() throws TipoMovimientoNoExisteException {
        TipoMovimiento unTipoMovimiento = TipoMovimiento.instancia(1, "TipoMovimiento 1");

        when(miTipoMovimientoObtenerPorIdRepository.obtenerTipoMovimiento(1)).thenReturn(unTipoMovimiento);

        TipoMovimientoObtenerPorIdUseCase tipoMovimientoObtenerPorIdUseCase = new TipoMovimientoObtenerPorIdUseCase(miTipoMovimientoObtenerPorIdRepository);
        TipoMovimiento resultado = tipoMovimientoObtenerPorIdUseCase.obtenerTipoMovimiento(1);
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerTipoMovimientoPorId_devuelveTipoMovimientoNoExiste() {

        when(miTipoMovimientoObtenerPorIdRepository.obtenerTipoMovimiento(1)).thenReturn(null);

        TipoMovimientoObtenerPorIdUseCase tipoMovimientoObtenerPorIdUseCase = new TipoMovimientoObtenerPorIdUseCase(miTipoMovimientoObtenerPorIdRepository);
        Assertions.assertThrows(TipoMovimientoNoExisteException.class, () -> tipoMovimientoObtenerPorIdUseCase.obtenerTipoMovimiento(1));
    }
}