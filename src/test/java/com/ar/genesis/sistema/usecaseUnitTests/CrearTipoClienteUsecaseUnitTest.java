package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Cliente;
import com.ar.genesis.sistema.core.domain.TipoCliente;
import com.ar.genesis.sistema.core.exception.ClienteExisteException;
import com.ar.genesis.sistema.core.exception.TipoClienteExisteException;
import com.ar.genesis.sistema.core.repository.IClienteRepository;
import com.ar.genesis.sistema.core.repository.ITipoClienteRepository;
import com.ar.genesis.sistema.core.usecase.CrearClienteUseCase;
import com.ar.genesis.sistema.core.usecase.CrearTipoClienteUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class CrearTipoClienteUsecaseUnitTest {
    @Mock
    ITipoClienteRepository iTipoClienteRepository;
    @Test
    void crearTipoCliente_TipoClienteNoExiste_GuardaCorrectamente() throws TipoClienteExisteException {
        TipoCliente tipoClienteNuevo = TipoCliente.instancia(1, "Cliente");
        when(iTipoClienteRepository.existeTipoCliente("Cliente")).thenReturn(false);
        when(iTipoClienteRepository.guardarTipoCliente(tipoClienteNuevo)).thenReturn(true);
        CrearTipoClienteUseCase crearTipoClienteUseCase = new CrearTipoClienteUseCase(iTipoClienteRepository);
        boolean resultado = crearTipoClienteUseCase.crearTipoCliente(tipoClienteNuevo);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearTipoCliente_TipoClienteExiste_NoGuardaCliente() {
        TipoCliente tipoClienteNuevo = TipoCliente.instancia(1, "Cliente");
        when(iTipoClienteRepository.existeTipoCliente("Cliente")).thenReturn(true);
        when(iTipoClienteRepository.guardarTipoCliente(tipoClienteNuevo)).thenReturn(false);
        CrearTipoClienteUseCase crearTipoClienteUseCase = new CrearTipoClienteUseCase(iTipoClienteRepository);
        Assertions.assertThrows(TipoClienteExisteException.class, () -> crearTipoClienteUseCase.crearTipoCliente(tipoClienteNuevo));
    }
}
