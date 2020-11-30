package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Localidad;
import com.ar.genesis.sistema.core.repository.ILocalidadObtenerRepository;
import com.ar.genesis.sistema.core.usecase.LocalidadObtenerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class LocalidadObtenerUseCaseTest {
    @Mock
    ILocalidadObtenerRepository miLocalidadObtenerRepository;
    @Spy
    List<Localidad> localidades = factoryListaLocalidades();

    @Test
    public void obtenerLocalidades_devuelveLista(){
        when(miLocalidadObtenerRepository.obtenerLocalidades()).thenReturn(localidades);
        LocalidadObtenerUseCase localidadObtenerUseCase = new LocalidadObtenerUseCase(miLocalidadObtenerRepository);
        List<Localidad> resultado = localidadObtenerUseCase.obtenerLocalidades();
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
