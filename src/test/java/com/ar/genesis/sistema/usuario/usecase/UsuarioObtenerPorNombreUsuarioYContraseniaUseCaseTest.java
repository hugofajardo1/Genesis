package com.ar.genesis.sistema.usuario.usecase;

import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import com.ar.genesis.sistema.usuario.core.exception.UsuarioNoExisteException;
import com.ar.genesis.sistema.usuario.core.repository.IUsuarioObtenerPorNombreUsuarioYContraseniaRepository;
import com.ar.genesis.sistema.usuario.core.usecase.UsuarioObtenerPorNombreUsuarioYContraseniaUseCase;
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
    public void obtenerUsuarioPorNombreUsuarioYContrasenia_devuelveUsuario() throws UsuarioNoExisteException {
        Usuario unUsuario = Usuario.instancia(1, "Usuario 1", "nombreusuario", "contrasenia", Sucursal.instancia(1, "Sucursal 1"));

        when(miUsuarioObtenerPorNombreUsuarioYContraseniaRepository.obtenerUsuario("nombreusuario", "contrasenia")).thenReturn(unUsuario);

        UsuarioObtenerPorNombreUsuarioYContraseniaUseCase usuarioObtenerPorNombreUsuarioYContraseniaUseCase = new UsuarioObtenerPorNombreUsuarioYContraseniaUseCase(miUsuarioObtenerPorNombreUsuarioYContraseniaRepository);
        Usuario resultado = usuarioObtenerPorNombreUsuarioYContraseniaUseCase.obtenerUsuario("nombreusuario", "contrasenia");
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerUsuarioPorNombreUsuarioYContrasenia_devuelveUsuarioNoExiste() {

        when(miUsuarioObtenerPorNombreUsuarioYContraseniaRepository.obtenerUsuario("nombreusuario", "contrasenia")).thenReturn(null);

        UsuarioObtenerPorNombreUsuarioYContraseniaUseCase usuarioObtenerPorNombreUsuarioYContraseniaUseCase = new UsuarioObtenerPorNombreUsuarioYContraseniaUseCase(miUsuarioObtenerPorNombreUsuarioYContraseniaRepository);
        Assertions.assertThrows(UsuarioNoExisteException.class, () -> usuarioObtenerPorNombreUsuarioYContraseniaUseCase.obtenerUsuario("nombreusuario", "contrasenia"));
    }
}