package com.ar.genesis.sistema.usuario.usecase;

import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import com.ar.genesis.sistema.usuario.core.exception.UsuarioExisteException;
import com.ar.genesis.sistema.usuario.core.repository.IUsuarioRepository;
import com.ar.genesis.sistema.usuario.core.usecase.UsuarioCrearUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class UsuarioCrearUseCaseTest {
    @Mock
    IUsuarioRepository miUsuarioRepository;
    @Test
    void crearUsuario_UsuarioNoExiste_GuardaCorrectamente() throws UsuarioExisteException {
        Usuario unUsuario = Usuario.instancia(1, "Usuario 1", "nombreusuario", "contrasenia", Sucursal.instancia(1, "Sucursal 1"));
        when(miUsuarioRepository.existeUsuario("Usuario 1")).thenReturn(false);
        when(miUsuarioRepository.guardarUsuario(unUsuario)).thenReturn(true);
        UsuarioCrearUseCase usuarioCrearUseCase = new UsuarioCrearUseCase(miUsuarioRepository);
        boolean resultado = usuarioCrearUseCase.crearUsuario(unUsuario);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearUsuario_UsuarioExiste_NoGuardaUsuario() {
        Usuario unUsuario = Usuario.instancia(1, "Usuario 1", "nombreusuario", "contrasenia", Sucursal.instancia(1, "Sucursal 1"));
        when(miUsuarioRepository.existeUsuario("Usuario 1")).thenReturn(true);
        when(miUsuarioRepository.guardarUsuario(unUsuario)).thenReturn(false);
        UsuarioCrearUseCase usuarioCrearUseCase = new UsuarioCrearUseCase(miUsuarioRepository);
        Assertions.assertThrows(UsuarioExisteException.class, () -> usuarioCrearUseCase.crearUsuario(unUsuario));
    }
}
