package com.ar.genesis.sistema.sucursalTest.usecase;

import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.sucursal.core.exception.SucursalExisteException;
import com.ar.genesis.sistema.sucursal.core.repository.ISucursalRepository;
import com.ar.genesis.sistema.sucursal.core.usecase.SucursalModificarUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class SucursalModificarUseCaseTest {
    @Mock
    ISucursalRepository miSucursalRepository;
    @Test
    void modificarSucursal_SucursalActualizadoCorrectamente() throws SucursalExisteException {
        Sucursal unaSucursal = Sucursal.instancia(1, "Sucursal");
        when(miSucursalRepository.existeSucursal("Sucursal")).thenReturn(false);
        when(miSucursalRepository.guardarSucursal(unaSucursal)).thenReturn(true);
        SucursalModificarUseCase sucursalModificarUseCase = new SucursalModificarUseCase(miSucursalRepository);
        boolean resultado = sucursalModificarUseCase.modificarSucursal(unaSucursal);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarSucursal_HayConflictoSucursalExiste_SucursalNoActualiza() {
        Sucursal unaSucursal = Sucursal.instancia(1, "Sucursal");
        when(miSucursalRepository.existeSucursal("Sucursal")).thenReturn(true);
        when(miSucursalRepository.guardarSucursal(unaSucursal)).thenReturn(false);
        SucursalModificarUseCase sucursalModificarUseCase = new SucursalModificarUseCase(miSucursalRepository);
        Assertions.assertThrows(SucursalExisteException.class, () -> sucursalModificarUseCase.modificarSucursal(unaSucursal));
    }
}
