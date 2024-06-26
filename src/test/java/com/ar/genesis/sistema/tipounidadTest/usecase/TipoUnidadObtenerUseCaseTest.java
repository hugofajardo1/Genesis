package com.ar.genesis.sistema.tipounidadTest.usecase;

import com.ar.genesis.sistema.tipounidad.core.domain.TipoUnidad;
import com.ar.genesis.sistema.tipounidad.core.repository.ITipoUnidadObtenerRepository;
import com.ar.genesis.sistema.tipounidad.core.usecase.TipoUnidadObtenerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class TipoUnidadObtenerUseCaseTest {
    @Mock
    ITipoUnidadObtenerRepository miTipoUnidadObtenerRepository;
    @Spy
    List<TipoUnidad> tipoUnidades = factoryListaTipoUnidades();

    @Test
    public void obtenerTipoUnidades_devuelveLista(){
        when(miTipoUnidadObtenerRepository.obtenerTipoUnidades()).thenReturn(tipoUnidades);
        TipoUnidadObtenerUseCase tipoUnidadObtenerUseCase = new TipoUnidadObtenerUseCase(miTipoUnidadObtenerRepository);
        List<TipoUnidad> resultado = tipoUnidadObtenerUseCase.obtenerTipoUnidades();
        Assertions.assertEquals(2,resultado.size());
    }

    public List<TipoUnidad> factoryListaTipoUnidades() {
        List<TipoUnidad> tipoUnidades = new ArrayList<>();
        TipoUnidad tipoUnidad1 = TipoUnidad.instancia(1, "Cliente");
        TipoUnidad tipoUnidad2 = TipoUnidad.instancia(2, "Proveedor");
        tipoUnidades.add(tipoUnidad1);
        tipoUnidades.add(tipoUnidad2);
        return tipoUnidades;
    }
}
