package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Proveedor;
import com.ar.genesis.sistema.core.exception.ProveedorExisteException;
import com.ar.genesis.sistema.core.repository.IProveedorRepository;
import com.ar.genesis.sistema.core.usecase.ProveedorModificarUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class ProveedorModificarUseCaseTest {
    @Mock
    IProveedorRepository miProveedorRepository;
    @Test
    void modificarProveedor_ProveedorActualizadoCorrectamente() throws ProveedorExisteException {
        Proveedor unProveedor = Proveedor.instancia(1, "Cliente");
        when(miProveedorRepository.existeProveedor("Cliente")).thenReturn(false);
        when(miProveedorRepository.guardarProveedor(unProveedor)).thenReturn(true);
        ProveedorModificarUseCase proveedorModificarUseCase = new ProveedorModificarUseCase(miProveedorRepository);
        boolean resultado = proveedorModificarUseCase.modificarProveedor(unProveedor);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarProveedor_HayConflictoProveedorExiste_ProveedorNoActualiza() {
        Proveedor unProveedor = Proveedor.instancia(1, "Cliente");
        when(miProveedorRepository.existeProveedor("Cliente")).thenReturn(true);
        when(miProveedorRepository.guardarProveedor(unProveedor)).thenReturn(false);
        ProveedorModificarUseCase proveedorModificarUseCase = new ProveedorModificarUseCase(miProveedorRepository);
        Assertions.assertThrows(ProveedorExisteException.class, () -> proveedorModificarUseCase.modificarProveedor(unProveedor));
    }
}
