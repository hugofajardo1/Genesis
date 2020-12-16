package com.ar.genesis.sistema.vendedor.usecase;

import com.ar.genesis.sistema.vendedor.core.domain.Vendedor;
import com.ar.genesis.sistema.vendedor.core.exception.VendedorExisteException;
import com.ar.genesis.sistema.vendedor.core.repository.IVendedorRepository;
import com.ar.genesis.sistema.vendedor.core.usecase.VendedorModificarUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class VendedorModificarUseCaseTest {
    @Mock
    IVendedorRepository miVendedorRepository;
    @Test
    void modificarVendedor_VendedorActualizadoCorrectamente() throws VendedorExisteException {
        Vendedor unVendedor = Vendedor.instancia(1, "Cliente");
        when(miVendedorRepository.existeVendedor("Cliente")).thenReturn(false);
        when(miVendedorRepository.guardarVendedor(unVendedor)).thenReturn(true);
        VendedorModificarUseCase vendedorModificarUseCase = new VendedorModificarUseCase(miVendedorRepository);
        boolean resultado = vendedorModificarUseCase.modificarVendedor(unVendedor);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarVendedor_HayConflictoVendedorExiste_VendedorNoActualiza() {
        Vendedor unVendedor = Vendedor.instancia(1, "Cliente");
        when(miVendedorRepository.existeVendedor("Cliente")).thenReturn(true);
        when(miVendedorRepository.guardarVendedor(unVendedor)).thenReturn(false);
        VendedorModificarUseCase vendedorModificarUseCase = new VendedorModificarUseCase(miVendedorRepository);
        Assertions.assertThrows(VendedorExisteException.class, () -> vendedorModificarUseCase.modificarVendedor(unVendedor));
    }
}
