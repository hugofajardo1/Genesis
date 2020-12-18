package com.ar.genesis.sistema.proveedorTest.usecase;

import com.ar.genesis.sistema.proveedor.core.domain.Proveedor;
import com.ar.genesis.sistema.proveedor.core.exception.ProveedorNoExisteException;
import com.ar.genesis.sistema.proveedor.core.repository.IProveedorObtenerPorIdRepository;
import com.ar.genesis.sistema.proveedor.core.usecase.ProveedorObtenerPorIdUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class ProveedorObtenerPorIdUseCaseTest {
    @Mock
    IProveedorObtenerPorIdRepository miProveedorObtenerPorIdRepository;

    @Test
    public void obtenerProveedorPorId_devuelveProveedor() throws ProveedorNoExisteException {
        Proveedor unProveedor = Proveedor.instancia(1, "Proveedor 1");

        when(miProveedorObtenerPorIdRepository.obtenerProveedor(1)).thenReturn(unProveedor);

        ProveedorObtenerPorIdUseCase proveedorObtenerPorIdUseCase = new ProveedorObtenerPorIdUseCase(miProveedorObtenerPorIdRepository);
        Proveedor resultado = proveedorObtenerPorIdUseCase.obtenerProveedor(1);
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerProveedorPorId_devuelveProveedorNoExiste() {

        when(miProveedorObtenerPorIdRepository.obtenerProveedor(1)).thenReturn(null);

        ProveedorObtenerPorIdUseCase proveedorObtenerPorIdUseCase = new ProveedorObtenerPorIdUseCase(miProveedorObtenerPorIdRepository);
        Assertions.assertThrows(ProveedorNoExisteException.class, () -> proveedorObtenerPorIdUseCase.obtenerProveedor(1));
    }
}