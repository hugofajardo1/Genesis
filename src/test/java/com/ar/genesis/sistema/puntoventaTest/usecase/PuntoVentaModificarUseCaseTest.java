package com.ar.genesis.sistema.puntoventaTest.usecase;

import com.ar.genesis.sistema.puntoventa.core.domain.PuntoVenta;
import com.ar.genesis.sistema.puntoventa.core.exception.PuntoVentaExisteException;
import com.ar.genesis.sistema.puntoventa.core.repository.IPuntoVentaRepository;
import com.ar.genesis.sistema.puntoventa.core.usecase.PuntoVentaModificarUseCase;
import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class PuntoVentaModificarUseCaseTest {
    @Mock
    IPuntoVentaRepository miPuntoVentaRepository;
    @Test
    void modificarPuntoVenta_PuntoVentaActualizadoCorrectamente() throws PuntoVentaExisteException {
        PuntoVenta unPuntoVenta = PuntoVenta.instancia(1, "PuntoVenta", Sucursal.instancia(1, "Sucursal 1"), 5);
        when(miPuntoVentaRepository.existePuntoVenta("PuntoVenta")).thenReturn(false);
        when(miPuntoVentaRepository.guardarPuntoVenta(unPuntoVenta)).thenReturn(true);
        PuntoVentaModificarUseCase puntoVentaModificarUseCase = new PuntoVentaModificarUseCase(miPuntoVentaRepository);
        boolean resultado = puntoVentaModificarUseCase.modificarPuntoVenta(unPuntoVenta);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarPuntoVenta_HayConflictoPuntoVentaExiste_PuntoVentaNoActualiza() {
        PuntoVenta unPuntoVenta = PuntoVenta.instancia(1, "PuntoVenta", Sucursal.instancia(1, "Sucursal 1"), 5);
        when(miPuntoVentaRepository.existePuntoVenta("PuntoVenta")).thenReturn(true);
        when(miPuntoVentaRepository.guardarPuntoVenta(unPuntoVenta)).thenReturn(false);
        PuntoVentaModificarUseCase puntoVentaModificarUseCase = new PuntoVentaModificarUseCase(miPuntoVentaRepository);
        Assertions.assertThrows(PuntoVentaExisteException.class, () -> puntoVentaModificarUseCase.modificarPuntoVenta(unPuntoVenta));
    }
}
