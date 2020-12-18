package com.ar.genesis.sistema.puntoventaTest.usecase;

import com.ar.genesis.sistema.puntoventa.core.domain.PuntoVenta;
import com.ar.genesis.sistema.puntoventa.core.exception.PuntoVentaExisteException;
import com.ar.genesis.sistema.puntoventa.core.repository.IPuntoVentaRepository;
import com.ar.genesis.sistema.puntoventa.core.usecase.PuntoVentaCrearUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class PuntoVentaCrearUseCaseTest {
    @Mock
    IPuntoVentaRepository miPuntoVentaRepository;
    @Test
    void crearPuntoVenta_PuntoVentaNoExiste_GuardaCorrectamente() throws PuntoVentaExisteException {
        PuntoVenta unPuntoVenta = PuntoVenta.instancia(1, "PuntoVenta 1", 5);
        when(miPuntoVentaRepository.existePuntoVenta("PuntoVenta 1")).thenReturn(false);
        when(miPuntoVentaRepository.guardarPuntoVenta(unPuntoVenta)).thenReturn(true);
        PuntoVentaCrearUseCase puntoVentaCrearUseCase = new PuntoVentaCrearUseCase(miPuntoVentaRepository);
        boolean resultado = puntoVentaCrearUseCase.crearPuntoVenta(unPuntoVenta);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearPuntoVenta_PuntoVentaExiste_NoGuardaPuntoVenta() {
        PuntoVenta unPuntoVenta = PuntoVenta.instancia(1, "PuntoVenta 1", 5);
        when(miPuntoVentaRepository.existePuntoVenta("PuntoVenta 1")).thenReturn(true);
        when(miPuntoVentaRepository.guardarPuntoVenta(unPuntoVenta)).thenReturn(false);
        PuntoVentaCrearUseCase puntoVentaCrearUseCase = new PuntoVentaCrearUseCase(miPuntoVentaRepository);
        Assertions.assertThrows(PuntoVentaExisteException.class, () -> puntoVentaCrearUseCase.crearPuntoVenta(unPuntoVenta));
    }
}
