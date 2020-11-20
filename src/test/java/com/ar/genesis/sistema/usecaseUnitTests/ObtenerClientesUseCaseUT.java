package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Cliente;
import com.ar.genesis.sistema.core.repository.IObtenerClientesRepository;
import com.ar.genesis.sistema.core.usecase.ObtenerClientesUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class ObtenerClientesUseCaseUT {
    @Mock
    IObtenerClientesRepository iObtenerClientesRepository;

    @Spy
    List<Cliente> clientes = factoryListaClientes();

    @Test
    public void obtenerClientes_devuelveLista(){
        when(iObtenerClientesRepository.obtenerClientes()).thenReturn(clientes);
        ObtenerClientesUseCase obtenerClientesUseCase = new ObtenerClientesUseCase(iObtenerClientesRepository);
        List<Cliente> resultado = obtenerClientesUseCase.obtenerClientes();
        Assertions.assertEquals(2,resultado.size());
    }

    public List<Cliente> factoryListaClientes() {

        List<Cliente> losClientes = new ArrayList<>();
        Cliente cliente1 = Cliente.instancia(1, "Fajardo, Hugo", "Bs As 245", "3825416543");
        Cliente cliente2 = Cliente.instancia(2, "Fajardo, Lourdes", "Juan XXIII 59", "5453454");
        losClientes.add(cliente1);
        losClientes.add(cliente2);
        return losClientes;
    }
}
