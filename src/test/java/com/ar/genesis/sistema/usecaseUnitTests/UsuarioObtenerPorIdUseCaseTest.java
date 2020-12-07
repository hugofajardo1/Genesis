package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Usuario;
import com.ar.genesis.sistema.core.exception.UsuarioNoExisteException;
import com.ar.genesis.sistema.core.repository.IUsuarioObtenerPorIdRepository;
import com.ar.genesis.sistema.core.usecase.UsuarioObtenerPorIdUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class UsuarioObtenerPorIdUseCaseTest {
    @Mock
    IUsuarioObtenerPorIdRepository miUsuarioObtenerPorIdRepository;

    @Test
    public void obtenerUsuarioPorNombreUsuarioYContrasenia_devuelveUsuario() throws UsuarioNoExisteException {
        Usuario unUsuario = Usuario.instancia(1, "Usuario 1", "nombreusuario", "contrasenia");

        when(miUsuarioObtenerPorIdRepository.obtenerUsuario(1)).thenReturn(unUsuario);

        UsuarioObtenerPorIdUseCase usuarioObtenerPorIdUseCase = new UsuarioObtenerPorIdUseCase(miUsuarioObtenerPorIdRepository);
        Usuario resultado = usuarioObtenerPorIdUseCase.obtenerUsuario(1);
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerUsuarioPorNombreUsuarioYContrasenia_devuelveUsuarioNoExiste() throws UsuarioNoExisteException {

        when(miUsuarioObtenerPorIdRepository.obtenerUsuario(1)).thenReturn(null);

        UsuarioObtenerPorIdUseCase usuarioObtenerPorIdUseCase = new UsuarioObtenerPorIdUseCase(miUsuarioObtenerPorIdRepository);
        Assertions.assertThrows(UsuarioNoExisteException.class, () -> usuarioObtenerPorIdUseCase.obtenerUsuario(1));
    }
}