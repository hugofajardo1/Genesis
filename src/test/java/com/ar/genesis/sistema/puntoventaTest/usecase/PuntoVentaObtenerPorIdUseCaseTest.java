package com.ar.genesis.sistema.puntoventaTest.usecase;

import com.ar.genesis.sistema.puntoventa.core.domain.PuntoVenta;
import com.ar.genesis.sistema.puntoventa.core.exception.PuntoVentaNoExisteException;
import com.ar.genesis.sistema.puntoventa.core.repository.IPuntoVentaObtenerPorIdRepository;
import com.ar.genesis.sistema.puntoventa.core.usecase.PuntoVentaObtenerPorIdUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class PuntoVentaObtenerPorIdUseCaseTest {
    @Mock
    IPuntoVentaObtenerPorIdRepository miPuntoVentaObtenerPorIdRepository;

    @Test
    public void obtenerPuntoVentaPorId_devuelvePuntoVenta() throws PuntoVentaNoExisteException {
        PuntoVenta unPuntoVenta = PuntoVenta.instancia(1, "PuntoVenta 1", 5);

        when(miPuntoVentaObtenerPorIdRepository.obtenerPuntoVenta(1)).thenReturn(unPuntoVenta);

        PuntoVentaObtenerPorIdUseCase puntoventaObtenerPorIdUseCase = new PuntoVentaObtenerPorIdUseCase(miPuntoVentaObtenerPorIdRepository);
        PuntoVenta resultado = puntoventaObtenerPorIdUseCase.obtenerPuntoVenta(1);
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerPuntoVentaPorId_devuelvePuntoVentaNoExiste() {

        when(miPuntoVentaObtenerPorIdRepository.obtenerPuntoVenta(1)).thenReturn(null);

        PuntoVentaObtenerPorIdUseCase puntoventaObtenerPorIdUseCase = new PuntoVentaObtenerPorIdUseCase(miPuntoVentaObtenerPorIdRepository);
        Assertions.assertThrows(PuntoVentaNoExisteException.class, () -> puntoventaObtenerPorIdUseCase.obtenerPuntoVenta(1));
    }
}