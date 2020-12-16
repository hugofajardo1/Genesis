package com.ar.genesis.sistema.vendedor.usecase;

import com.ar.genesis.sistema.vendedor.core.domain.Vendedor;
import com.ar.genesis.sistema.vendedor.core.repository.IVendedorObtenerRepository;
import com.ar.genesis.sistema.vendedor.core.usecase.VendedorObtenerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class VendedorObtenerUseCaseTest {
    @Mock
    IVendedorObtenerRepository miVendedorObtenerRepository;
    @Spy
    List<Vendedor> vendedores = factoryListaVendedors();

    @Test
    public void obtenerVendedors_devuelveLista(){
        when(miVendedorObtenerRepository.obtenerVendedores()).thenReturn(vendedores);
        VendedorObtenerUseCase vendedorObtenerUseCase = new VendedorObtenerUseCase(miVendedorObtenerRepository);
        List<Vendedor> resultado = vendedorObtenerUseCase.obtenerVendedores();
        Assertions.assertEquals(2,resultado.size());
    }

    public List<Vendedor> factoryListaVendedors() {
        List<Vendedor> vendedores = new ArrayList<>();
        Vendedor vendedor1 = Vendedor.instancia(1, "Vendedor 1");
        Vendedor vendedor2 = Vendedor.instancia(2, "Vendedor 2");
        vendedores.add(vendedor1);
        vendedores.add(vendedor2);
        return vendedores;
    }
}
