package com.ar.genesis.sistema.tipooperacionTest.usecase;

import com.ar.genesis.sistema.tipooperacion.core.domain.TipoOperacion;
import com.ar.genesis.sistema.tipooperacion.core.repository.ITipoOperacionObtenerRepository;
import com.ar.genesis.sistema.tipooperacion.core.usecase.TipoOperacionObtenerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class TipoOperacionObtenerUseCaseTest {
    @Mock
    ITipoOperacionObtenerRepository miTipoOperacionObtenerRepository;
    @Spy
    List<TipoOperacion> tipoOperaciones = factoryListaTipoOperaciones();

    @Test
    public void obtenerTipoOperaciones_devuelveLista(){
        when(miTipoOperacionObtenerRepository.obtenerTipoOperaciones()).thenReturn(tipoOperaciones);
        TipoOperacionObtenerUseCase tipoOperacionObtenerUseCase = new TipoOperacionObtenerUseCase(miTipoOperacionObtenerRepository);
        List<TipoOperacion> resultado = tipoOperacionObtenerUseCase.obtenerTipoOperaciones();
        Assertions.assertEquals(2,resultado.size());
    }

    public List<TipoOperacion> factoryListaTipoOperaciones() {
        List<TipoOperacion> tipoOperaciones = new ArrayList<>();
        TipoOperacion tipoOperacion1 = TipoOperacion.instancia(1, "Venta");
        TipoOperacion tipoOperacion2 = TipoOperacion.instancia(2, "Compra");
        tipoOperaciones.add(tipoOperacion1);
        tipoOperaciones.add(tipoOperacion2);
        return tipoOperaciones;
    }
}
