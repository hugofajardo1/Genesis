package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.core.repository.IObtenerTipoMovimientosRepository;
import com.ar.genesis.sistema.core.usecase.ObtenerTipoMovimientosUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class ObtenerTipoMovimientosUseCaseTest {
    @Mock
    IObtenerTipoMovimientosRepository iObtenerTipoMovimientosRepository;
    @Spy
    List<TipoMovimiento> tipoMovimientos = factoryListaTipoMovimientos();

    @Test
    public void obtenerTipoMovimientos_devuelveLista(){
        when(iObtenerTipoMovimientosRepository.obtenerTipoMovimientos()).thenReturn(tipoMovimientos);
        ObtenerTipoMovimientosUseCase obtenerTipoMovimientosUseCase = new ObtenerTipoMovimientosUseCase(iObtenerTipoMovimientosRepository);
        List<TipoMovimiento> resultado = obtenerTipoMovimientosUseCase.obtenerTipoMovimientos();
        Assertions.assertEquals(2,resultado.size());
    }

    public List<TipoMovimiento> factoryListaTipoMovimientos() {
        List<TipoMovimiento> losTipoMovimientos = new ArrayList<>();
        TipoMovimiento TipoMovimiento1 = TipoMovimiento.instancia(1, "Factura A");
        TipoMovimiento TipoMovimiento2 = TipoMovimiento.instancia(2, "Nota de Debito A");
        losTipoMovimientos.add(TipoMovimiento1);
        losTipoMovimientos.add(TipoMovimiento2);
        return losTipoMovimientos;
    }
}
