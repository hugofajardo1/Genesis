package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Provincia;
import com.ar.genesis.sistema.core.repository.IObtenerProvinciasRepository;
import com.ar.genesis.sistema.core.usecase.ObtenerProvinciasUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class ObtenerProvinciasUseCaseTest {
    @Mock
    IObtenerProvinciasRepository miObtenerProvinciasRepository;
    @Spy
    List<Provincia> provincias = factoryListaProvincias();

    @Test
    public void obtenerProvincias_devuelveLista(){
        when(miObtenerProvinciasRepository.obtenerProvincias()).thenReturn(provincias);
        ObtenerProvinciasUseCase obtenerProvinciasUseCase = new ObtenerProvinciasUseCase(miObtenerProvinciasRepository);
        List<Provincia> resultado = obtenerProvinciasUseCase.obtenerProvincias();
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
