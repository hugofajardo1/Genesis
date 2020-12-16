package com.ar.genesis.sistema.proveedor.usecase;

import com.ar.genesis.sistema.proveedor.core.domain.Proveedor;
import com.ar.genesis.sistema.proveedor.core.repository.IProveedorObtenerRepository;
import com.ar.genesis.sistema.proveedor.core.usecase.ProveedorObtenerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class ProveedorObtenerUseCaseTest {
    @Mock
    IProveedorObtenerRepository miProveedorObtenerRepository;
    @Spy
    List<Proveedor> proveedores = factoryListaProveedors();

    @Test
    public void obtenerProveedors_devuelveLista(){
        when(miProveedorObtenerRepository.obtenerProveedores()).thenReturn(proveedores);
        ProveedorObtenerUseCase proveedorObtenerUseCase = new ProveedorObtenerUseCase(miProveedorObtenerRepository);
        List<Proveedor> resultado = proveedorObtenerUseCase.obtenerProveedores();
        Assertions.assertEquals(2,resultado.size());
    }

    public List<Proveedor> factoryListaProveedors() {
        List<Proveedor> Proveedores = new ArrayList<>();
        Proveedor proveedor1 = Proveedor.instancia(1, "Proveedor 1");
        Proveedor proveedor2 = Proveedor.instancia(2, "Proveedor 2");
        Proveedores.add(proveedor1);
        Proveedores.add(proveedor2);
        return Proveedores;
    }
}
