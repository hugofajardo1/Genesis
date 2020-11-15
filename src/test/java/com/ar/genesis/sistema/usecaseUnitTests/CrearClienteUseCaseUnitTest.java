package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Cliente;
import com.ar.genesis.sistema.core.exception.ClienteExisteException;
import com.ar.genesis.sistema.core.repository.IClienteRepository;
import com.ar.genesis.sistema.core.usecase.CrearClienteUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class CrearClienteUseCaseUnitTest {
    @Mock
    IClienteRepository iClienteRepository;

    @Test
    void crearCliente_ClienteNoExiste_GuardaCorrectamente() throws ClienteExisteException {
        Cliente clienteNuevo = Cliente.instancia(1, "Fajardo, Hugo", "Bs As 245", "3825416543");
        when(iClienteRepository.existeCliente("Fajardo, Hugo")).thenReturn(false);
        when(iClienteRepository.guardarCliente(clienteNuevo)).thenReturn(true);
        CrearClienteUseCase crearClienteUseCase = new CrearClienteUseCase(iClienteRepository);
        boolean resultado = crearClienteUseCase.crearCliente(clienteNuevo);
        Assertions.assertTrue(resultado);
    }
    @Test
    void crearCliente_ClienteExiste_NoGuardaCliente() {
        Cliente clienteNuevo = Cliente.instancia(1, "Fajardo, Hugo", "Bs As 245", "3825416543");
        when(iClienteRepository.existeCliente("Fajardo, Hugo")).thenReturn(true);
        when(iClienteRepository.guardarCliente(clienteNuevo)).thenReturn(false);
        CrearClienteUseCase crearClienteUseCase = new CrearClienteUseCase(iClienteRepository);
        Assertions.assertThrows(ClienteExisteException.class, () -> crearClienteUseCase.crearCliente(clienteNuevo));
    }
}