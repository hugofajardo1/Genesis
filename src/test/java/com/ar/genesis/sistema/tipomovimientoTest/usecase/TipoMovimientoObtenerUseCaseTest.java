package com.ar.genesis.sistema.tipomovimientoTest.usecase;

import com.ar.genesis.sistema.tipomovimiento.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.tipomovimiento.core.repository.ITipoMovimientoObtenerRepository;
import com.ar.genesis.sistema.tipomovimiento.core.usecase.TipoMovimientoObtenerUseCase;
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
    ITipoMovimientoObtenerRepository miTipoMovimientoObtenerRepository;
    @Spy
    List<TipoMovimiento> tipoMovimientos = factoryListaTipoMovimientos();

    @Test
    public void obtenerTipoMovimientos_devuelveLista(){
        when(miTipoMovimientoObtenerRepository.obtenerTipoMovimientos()).thenReturn(tipoMovimientos);
        TipoMovimientoObtenerUseCase tipoMovimientoObtenerUseCase = new TipoMovimientoObtenerUseCase(miTipoMovimientoObtenerRepository);
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
