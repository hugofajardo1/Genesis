package com.ar.genesis.sistema.puntoventaTest.usecase;

import com.ar.genesis.sistema.puntoventa.core.domain.PuntoVenta;
import com.ar.genesis.sistema.puntoventa.core.repository.IPuntoVentaObtenerRepository;
import com.ar.genesis.sistema.puntoventa.core.usecase.PuntoVentaObtenerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class PuntoVentaObtenerUseCaseTest {
    @Mock
    IPuntoVentaObtenerRepository miPuntoVentaObtenerRepository;
    @Spy
    List<PuntoVenta> puntoVentas = factoryListaPuntoVentas();

    @Test
    public void obtenerPuntoVentas_devuelveLista(){
        when(miPuntoVentaObtenerRepository.obtenerPuntoVentas()).thenReturn(puntoVentas);
        PuntoVentaObtenerUseCase puntoventaObtenerUseCase = new PuntoVentaObtenerUseCase(miPuntoVentaObtenerRepository);
        List<PuntoVenta> resultado = puntoventaObtenerUseCase.obtenerPuntoVentas();
        Assertions.assertEquals(2,resultado.size());
    }

    public List<PuntoVenta> factoryListaPuntoVentas() {
        List<PuntoVenta> puntoventas = new ArrayList<>();
        PuntoVenta puntoventa1 = PuntoVenta.instancia(1, "PuntoVenta 1", 5);
        PuntoVenta puntoventa2 = PuntoVenta.instancia(2, "PuntoVenta 2", 5);
        puntoventas.add(puntoventa1);
        puntoventas.add(puntoventa2);
        return puntoventas;
    }
}
