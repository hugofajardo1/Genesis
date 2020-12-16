package com.ar.genesis.sistema.vendedor.usecase;

import com.ar.genesis.sistema.vendedor.core.domain.Vendedor;
import com.ar.genesis.sistema.vendedor.core.exception.VendedorExisteException;
import com.ar.genesis.sistema.vendedor.core.repository.IVendedorRepository;
import com.ar.genesis.sistema.vendedor.core.usecase.VendedorCrearUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class VendedorCrearUseCaseTest {
    @Mock
    IVendedorRepository miVendedorRepository;
    @Test
    void crearVendedor_VendedorNoExiste_GuardaCorrectamente() throws VendedorExisteException {
        Vendedor unVendedor = Vendedor.instancia(1, "Vendedor 1");
        when(miVendedorRepository.existeVendedor("Vendedor 1")).thenReturn(false);
        when(miVendedorRepository.guardarVendedor(unVendedor)).thenReturn(true);
        VendedorCrearUseCase VendedorCrearUseCase = new VendedorCrearUseCase(miVendedorRepository);
        boolean resultado = VendedorCrearUseCase.crearVendedor(unVendedor);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearVendedor_VendedorExiste_NoGuardaVendedor() {
        Vendedor unVendedor = Vendedor.instancia(1, "Vendedor 1");
        when(miVendedorRepository.existeVendedor("Vendedor 1")).thenReturn(true);
        when(miVendedorRepository.guardarVendedor(unVendedor)).thenReturn(false);
        VendedorCrearUseCase VendedorCrearUseCase = new VendedorCrearUseCase(miVendedorRepository);
        Assertions.assertThrows(VendedorExisteException.class, () -> VendedorCrearUseCase.crearVendedor(unVendedor));
    }
}
