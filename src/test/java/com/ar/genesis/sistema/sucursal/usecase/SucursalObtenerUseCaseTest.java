package com.ar.genesis.sistema.sucursal.usecase;

import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.sucursal.core.repository.ISucursalObtenerRepository;
import com.ar.genesis.sistema.sucursal.core.usecase.SucursalObtenerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class SucursalObtenerUseCaseTest {
    @Mock
    ISucursalObtenerRepository miSucursalObtenerRepository;
    @Spy
    List<Sucursal> sucursales = factoryListaSucursales();

    @Test
    public void obtenerSucursales_devuelveLista(){
        when(miSucursalObtenerRepository.obtenerSucursales()).thenReturn(sucursales);
        SucursalObtenerUseCase sucursalObtenerUseCase = new SucursalObtenerUseCase(miSucursalObtenerRepository);
        List<Sucursal> resultado = sucursalObtenerUseCase.obtenerSucursales();
        Assertions.assertEquals(2,resultado.size());
    }

    public List<Sucursal> factoryListaSucursales() {
        List<Sucursal> sucursales = new ArrayList<>();
        Sucursal sucursal1 = Sucursal.instancia(1, "Sucursal 1");
        Sucursal sucursal2 = Sucursal.instancia(2, "Sucursal 2");
        sucursales.add(sucursal1);
        sucursales.add(sucursal2);
        return sucursales;
    }
}
