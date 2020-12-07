package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Usuario;
import com.ar.genesis.sistema.core.exception.UsuarioNoExisteException;
import com.ar.genesis.sistema.core.repository.IUsuarioObtenerPorNombreUsuarioYContraseniaRepository;
import com.ar.genesis.sistema.core.usecase.UsuarioObtenerPorNombreUsuarioYContraseniaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class UsuarioObtenerPorNombreUsuarioYContraseniaUseCaseTest {
    @Mock
    IUsuarioObtenerPorNombreUsuarioYContraseniaRepository miUsuarioObtenerPorNombreUsuarioYContraseniaRepository;

    @Test
    public void obtenerUsuarioPorNombreUsuarioYContrasenia_devuelveUsuario() {
        Usuario unUsuario = Usuario.instancia(1, "Usuario 1", "nombreusuario", "contrasenia");

        when(miUsuarioObtenerPorNombreUsuarioYContraseniaRepository.obtenerUsuario("nombreusuario", "contrasenia")).thenReturn(unUsuario);

        UsuarioObtenerPorNombreUsuarioYContraseniaUseCase usuarioObtenerPorNombreUsuarioYContraseniaUseCase = new UsuarioObtenerPorNombreUsuarioYContraseniaUseCase(miUsuarioObtenerPorNombreUsuarioYContraseniaRepository);
        Usuario resultado = usuarioObtenerPorNombreUsuarioYContraseniaUseCase.obtenerUsuario("nombreusuario", "contrasenia");
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerUsuarioPorNombreUsuarioYContrasenia_devuelveUsuarioNoExiste() {

        when(miUsuarioObtenerPorNombreUsuarioYContraseniaRepository.obtenerUsuario("nombreusuario", "contrasenia")).thenReturn(null);

        UsuarioObtenerPorNombreUsuarioYContraseniaUseCase usuarioObtenerPorNombreUsuarioYContraseniaUseCase = new UsuarioObtenerPorNombreUsuarioYContraseniaUseCase(miUsuarioObtenerPorNombreUsuarioYContraseniaRepository);
        Assertions.assertNull(usuarioObtenerPorNombreUsuarioYContraseniaUseCase.obtenerUsuario("nombreusuario", "contrasenia"));
    }
}