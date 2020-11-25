package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Cliente;
import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.core.exception.ClienteExisteException;
import com.ar.genesis.sistema.core.repository.IClienteRepository;
import com.ar.genesis.sistema.core.usecase.ModificarClienteUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class ModificarClienteUseCaseTest {
    @Mock
    IClienteRepository iClienteRepository;

    @Test
    void modificarCliente_ClienteActualizadoCorrectamente() throws ClienteExisteException {
        Cliente clienteNuevo = Cliente.instancia(1, "Fajardo, Hugo", "Bs As 245", "3825416543", TipoIva.instancia(1, "Responsable Inscripto"));
        when(iClienteRepository.existeCliente("Fajardo, Hugo")).thenReturn(false);
        when(iClienteRepository.guardarCliente(clienteNuevo)).thenReturn(true);
        ModificarClienteUseCase modificarTipoClienteUseCase = new ModificarClienteUseCase(iClienteRepository);
        boolean resultado = modificarTipoClienteUseCase.modificarCliente(clienteNuevo);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarCliente_HayConflictoClienteExiste_ClienteNoActualiza() {
        Cliente clienteNuevo = Cliente.instancia(1, "Fajardo, Hugo", "Bs As 245", "3825416543", TipoIva.instancia(1, "Responsable Inscripto"));
        when(iClienteRepository.existeCliente("Fajardo, Hugo")).thenReturn(true);
        when(iClienteRepository.guardarCliente(clienteNuevo)).thenReturn(false);
        ModificarClienteUseCase modificarClienteUseCase = new ModificarClienteUseCase(iClienteRepository);
        Assertions.assertThrows(ClienteExisteException.class, () -> modificarClienteUseCase.modificarCliente(clienteNuevo));
    }
}