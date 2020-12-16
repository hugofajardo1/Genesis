package com.ar.genesis.sistema.vendedor.usecase;

import com.ar.genesis.sistema.vendedor.core.domain.Vendedor;
import com.ar.genesis.sistema.vendedor.core.exception.VendedorNoExisteException;
import com.ar.genesis.sistema.vendedor.core.repository.IVendedorObtenerPorIdRepository;
import com.ar.genesis.sistema.vendedor.core.usecase.VendedorObtenerPorIdUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class VendedorObtenerPorIdUseCaseTest {
    @Mock
    IVendedorObtenerPorIdRepository miVendedorObtenerPorIdRepository;

    @Test
    public void obtenerVendedorPorId_devuelveVendedor() throws VendedorNoExisteException {
        Vendedor unVendedor = Vendedor.instancia(1, "Vendedor 1");

        when(miVendedorObtenerPorIdRepository.obtenerVendedor(1)).thenReturn(unVendedor);

        VendedorObtenerPorIdUseCase vendedorObtenerPorIdUseCase = new VendedorObtenerPorIdUseCase(miVendedorObtenerPorIdRepository);
        Vendedor resultado = vendedorObtenerPorIdUseCase.obtenerVendedor(1);
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerVendedorPorId_devuelveVendedorNoExiste() {

        when(miVendedorObtenerPorIdRepository.obtenerVendedor(1)).thenReturn(null);

        VendedorObtenerPorIdUseCase vendedorObtenerPorIdUseCase = new VendedorObtenerPorIdUseCase(miVendedorObtenerPorIdRepository);
        Assertions.assertThrows(VendedorNoExisteException.class, () -> vendedorObtenerPorIdUseCase.obtenerVendedor(1));
    }
}