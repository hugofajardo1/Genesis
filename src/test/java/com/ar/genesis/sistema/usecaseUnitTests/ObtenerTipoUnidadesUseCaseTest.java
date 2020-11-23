package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.TipoUnidad;
import com.ar.genesis.sistema.core.repository.IObtenerTipoUnidadesRepository;
import com.ar.genesis.sistema.core.usecase.ObtenerTipoUnidadesUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class ObtenerTipoUnidadesUseCaseTest {
    @Mock
    IObtenerTipoUnidadesRepository iObtenerTipoUnidadesRepository;
    @Spy
    List<TipoUnidad> tipoUnidades = factoryListaTipoUnidades();

    @Test
    public void obtenerTipoUnidades_devuelveLista(){
        when(iObtenerTipoUnidadesRepository.obtenerTipoUnidades()).thenReturn(tipoUnidades);
        ObtenerTipoUnidadesUseCase obtenerTipoUnidadesUseCase = new ObtenerTipoUnidadesUseCase(iObtenerTipoUnidadesRepository);
        List<TipoUnidad> resultado = obtenerTipoUnidadesUseCase.obtenerTipoUnidades();
        Assertions.assertEquals(2,resultado.size());
    }

    public List<TipoUnidad> factoryListaTipoUnidades() {
        List<TipoUnidad> losTipoUnidades = new ArrayList<>();
        TipoUnidad TipoUnidad1 = TipoUnidad.instancia(1, "Cliente");
        TipoUnidad TipoUnidad2 = TipoUnidad.instancia(2, "Proveedor");
        losTipoUnidades.add(TipoUnidad1);
        losTipoUnidades.add(TipoUnidad2);
        return losTipoUnidades;
    }
}
