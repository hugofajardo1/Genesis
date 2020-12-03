package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Proveedor;
import com.ar.genesis.sistema.core.exception.ProveedorExisteException;
import com.ar.genesis.sistema.core.repository.IProveedorRepository;
import com.ar.genesis.sistema.core.usecase.ProveedorCrearUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class ProveedorCrearUseCaseTest {
    @Mock
    IProveedorRepository miProveedorRepository;
    @Test
    void crearProveedor_ProveedorNoExiste_GuardaCorrectamente() throws ProveedorExisteException {
        Proveedor unProveedor = Proveedor.instancia(1, "Proveedor 1");
        when(miProveedorRepository.existeProveedor("Proveedor 1")).thenReturn(false);
        when(miProveedorRepository.guardarProveedor(unProveedor)).thenReturn(true);
        ProveedorCrearUseCase proveedorCrearUseCase = new ProveedorCrearUseCase(miProveedorRepository);
        boolean resultado = proveedorCrearUseCase.crearProveedor(unProveedor);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearProveedor_ProveedorExiste_NoGuardaProveedor() {
        Proveedor unProveedor = Proveedor.instancia(1, "Proveedor 1");
        when(miProveedorRepository.existeProveedor("Proveedor 1")).thenReturn(true);
        when(miProveedorRepository.guardarProveedor(unProveedor)).thenReturn(false);
        ProveedorCrearUseCase proveedorCrearUseCase = new ProveedorCrearUseCase(miProveedorRepository);
        Assertions.assertThrows(ProveedorExisteException.class, () -> proveedorCrearUseCase.crearProveedor(unProveedor));
    }
}
