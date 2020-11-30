package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Provincia;
import com.ar.genesis.sistema.core.repository.IProvinciaObtenerRepository;
import com.ar.genesis.sistema.core.usecase.ProvinciaProvinciaObtenerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class ProvinciaObtenerUseCaseTest {
    @Mock
    IProvinciaObtenerRepository miProvinciaObtenerRepository;
    @Spy
    List<Provincia> provincias = factoryListaProvincias();

    @Test
    public void obtenerProvincias_devuelveLista(){
        when(miProvinciaObtenerRepository.obtenerProvincias()).thenReturn(provincias);
        ProvinciaProvinciaObtenerUseCase provinciaObtenerUseCase = new ProvinciaProvinciaObtenerUseCase(miProvinciaObtenerRepository);
        List<Provincia> resultado = provinciaObtenerUseCase.obtenerProvincias();
        Assertions.assertEquals(2,resultado.size());
    }

    public List<Provincia> factoryListaProvincias() {
        List<Provincia> provincias = new ArrayList<>();
        Provincia provincia1 = Provincia.instancia(1, "Provincia 1");
        Provincia provincia2 = Provincia.instancia(2, "Provincia 2");
        provincias.add(provincia1);
        provincias.add(provincia2);
        return provincias;
    }
}
