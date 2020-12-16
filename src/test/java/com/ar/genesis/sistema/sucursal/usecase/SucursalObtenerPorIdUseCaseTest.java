package com.ar.genesis.sistema.sucursal.usecase;

import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.sucursal.core.exception.SucursalNoExisteException;
import com.ar.genesis.sistema.sucursal.core.repository.ISucursalObtenerPorIdRepository;
import com.ar.genesis.sistema.sucursal.core.usecase.SucursalObtenerPorIdUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class SucursalObtenerPorIdUseCaseTest {
    @Mock
    ISucursalObtenerPorIdRepository miSucursalObtenerPorIdRepository;

    @Test
    public void obtenerSucursalPorId_devuelveSucursal() throws SucursalNoExisteException {
        Sucursal unaSucursal = Sucursal.instancia(1, "Sucursal 1");

        when(miSucursalObtenerPorIdRepository.obtenerSucursal(1)).thenReturn(unaSucursal);

        SucursalObtenerPorIdUseCase sucursalObtenerPorIdUseCase = new SucursalObtenerPorIdUseCase(miSucursalObtenerPorIdRepository);
        Sucursal resultado = sucursalObtenerPorIdUseCase.obtenerSucursal(1);
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerSucursalPorId_devuelveSucursalNoExiste() {

        when(miSucursalObtenerPorIdRepository.obtenerSucursal(1)).thenReturn(null);

        SucursalObtenerPorIdUseCase sucursalObtenerPorIdUseCase = new SucursalObtenerPorIdUseCase(miSucursalObtenerPorIdRepository);
        Assertions.assertThrows(SucursalNoExisteException.class, () -> sucursalObtenerPorIdUseCase.obtenerSucursal(1));
    }
}