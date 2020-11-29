package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.core.repository.IObtenerTipoMovimientosRepository;
import com.ar.genesis.sistema.core.usecase.TipoMovimientoObtenerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class TipoMovimientoObtenerUseCaseTest {
    @Mock
    IObtenerTipoMovimientosRepository miObtenerTipoMovimientosRepository;
    @Spy
    List<TipoMovimiento> tipoMovimientos = factoryListaTipoMovimientos();

    @Test
    public void obtenerTipoMovimientos_devuelveLista(){
        when(miObtenerTipoMovimientosRepository.obtenerTipoMovimientos()).thenReturn(tipoMovimientos);
        TipoMovimientoObtenerUseCase tipoMovimientoObtenerUseCase = new TipoMovimientoObtenerUseCase(miObtenerTipoMovimientosRepository);
        List<TipoMovimiento> resultado = tipoMovimientoObtenerUseCase.obtenerTipoMovimientos();
        Assertions.assertEquals(2,resultado.size());
    }

    public List<TipoMovimiento> factoryListaTipoMovimientos() {
        List<TipoMovimiento> tipoMovimientos = new ArrayList<>();
        TipoMovimiento tipoMovimiento1 = TipoMovimiento.instancia(1, "Factura A");
        TipoMovimiento tipoMovimiento2 = TipoMovimiento.instancia(2, "Nota de Debito A");
        tipoMovimientos.add(tipoMovimiento1);
        tipoMovimientos.add(tipoMovimiento2);
        return tipoMovimientos;
    }
}
