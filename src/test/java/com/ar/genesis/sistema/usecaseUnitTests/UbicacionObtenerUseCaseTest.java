package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Ubicacion;
import com.ar.genesis.sistema.core.repository.IUbicacionObtenerRepository;
import com.ar.genesis.sistema.core.usecase.UbicacionObtenerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class UbicacionObtenerUseCaseTest {
    @Mock
    IUbicacionObtenerRepository miUbicacionObtenerRepository;
    @Spy
    List<Ubicacion> ubicaciones = factoryListaUbicaciones();

    @Test
    public void obtenerUbicaciones_devuelveLista(){
        when(miUbicacionObtenerRepository.obtenerUbicaciones()).thenReturn(ubicaciones);
        UbicacionObtenerUseCase ubicacionObtenerUseCase = new UbicacionObtenerUseCase(miUbicacionObtenerRepository);
        List<Ubicacion> resultado = ubicacionObtenerUseCase.obtenerUbicaciones();
        Assertions.assertEquals(2,resultado.size());
    }

    public List<Ubicacion> factoryListaUbicaciones() {
        List<Ubicacion> ubicaciones = new ArrayList<>();
        Ubicacion ubicacion1 = Ubicacion.instancia(1, "Ubicacion 1");
        Ubicacion ubicacion2 = Ubicacion.instancia(2, "Ubicacion 2");
        ubicaciones.add(ubicacion1);
        ubicaciones.add(ubicacion2);
        return ubicaciones;
    }
}
