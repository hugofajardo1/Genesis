package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.core.exception.TipoMovimientoNoExisteException;
import com.ar.genesis.sistema.core.repository.ITipoMovimientoObtenerPorIdRepository;
import com.ar.genesis.sistema.core.usecase.TipoMovimientoObtenerPorIdUseCase;
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
    public void obtenerTipoMovimientoPorId_devuelveTipoMovimientoNoExiste() throws TipoMovimientoNoExisteException {

        when(miTipoMovimientoObtenerPorIdRepository.obtenerTipoMovimiento(1)).thenReturn(null);

        TipoMovimientoObtenerPorIdUseCase tipoMovimientoObtenerPorIdUseCase = new TipoMovimientoObtenerPorIdUseCase(miTipoMovimientoObtenerPorIdRepository);
        Assertions.assertThrows(TipoMovimientoNoExisteException.class, () -> tipoMovimientoObtenerPorIdUseCase.obtenerTipoMovimiento(1));
    }
}