package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Sucursal;
import com.ar.genesis.sistema.core.exception.SucursalExisteException;
import com.ar.genesis.sistema.core.repository.ISucursalRepository;
import com.ar.genesis.sistema.core.usecase.SucursalCrearUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class SucursalCrearUseCaseTest {
    @Mock
    ISucursalRepository miSucursalRepository;
    @Test
    void crearSucursal_SucursalNoExiste_GuardaCorrectamente() throws SucursalExisteException {
        Sucursal unaSucursal = Sucursal.instancia(1, "Sucursal 1");
        when(miSucursalRepository.existeSucursal("Sucursal 1")).thenReturn(false);
        when(miSucursalRepository.guardarSucursal(unaSucursal)).thenReturn(true);
        SucursalCrearUseCase sucursalCrearUseCase = new SucursalCrearUseCase(miSucursalRepository);
        boolean resultado = sucursalCrearUseCase.crearSucursal(unaSucursal);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearSucursal_SucursalExiste_NoGuardaSucursal() throws SucursalExisteException {
        Sucursal unaSucursal = Sucursal.instancia(1, "Sucursal 1");
        when(miSucursalRepository.existeSucursal("Sucursal 1")).thenReturn(true);
        when(miSucursalRepository.guardarSucursal(unaSucursal)).thenReturn(false);
        SucursalCrearUseCase sucursalCrearUseCase = new SucursalCrearUseCase(miSucursalRepository);
        Assertions.assertThrows(SucursalExisteException.class, () -> sucursalCrearUseCase.crearSucursal(unaSucursal));
    }
}
