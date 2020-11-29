package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Localidad;
import com.ar.genesis.sistema.core.repository.IObtenerLocalidadesRepository;
import com.ar.genesis.sistema.core.usecase.ObtenerLocalidadesUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class ObtenerLocalidadesUseCaseTest {
    @Mock
    IObtenerLocalidadesRepository miObtenerLocalidadesRepository;
    @Spy
    List<Localidad> localidades = factoryListaLocalidades();

    @Test
    public void obtenerLocalidades_devuelveLista(){
        when(miObtenerLocalidadesRepository.obtenerLocalidades()).thenReturn(localidades);
        ObtenerLocalidadesUseCase obtenerLocalidadesUseCase = new ObtenerLocalidadesUseCase(miObtenerLocalidadesRepository);
        List<Localidad> resultado = obtenerLocalidadesUseCase.obtenerLocalidades();
        Assertions.assertEquals(2,resultado.size());
    }

    public List<Localidad> factoryListaLocalidades() {
        List<Localidad> localidades = new ArrayList<>();
        Localidad localidad1 = Localidad.instancia(1, "Localidad 1");
        Localidad localidad2 = Localidad.instancia(2, "Localidad 2");
        localidades.add(localidad1);
        localidades.add(localidad2);
        return localidades;
    }
}
