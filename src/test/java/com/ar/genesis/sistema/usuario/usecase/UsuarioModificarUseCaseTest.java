package com.ar.genesis.sistema.usuario.usecase;

import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import com.ar.genesis.sistema.usuario.core.exception.UsuarioExisteException;
import com.ar.genesis.sistema.usuario.core.repository.IUsuarioRepository;
import com.ar.genesis.sistema.usuario.core.usecase.UsuarioModificarUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class UsuarioModificarUseCaseTest {
    @Mock
    IUsuarioRepository miUsuarioRepository;
    @Test
    void modificarUsuario_UsuarioActualizadoCorrectamente() throws UsuarioExisteException {
        Usuario unUsuario = Usuario.instancia(1, "Cliente", "nombreusuario", "contrasenia", Sucursal.instancia(1, "Sucursal 1"));
        when(miUsuarioRepository.existeUsuario("Cliente")).thenReturn(false);
        when(miUsuarioRepository.guardarUsuario(unUsuario)).thenReturn(true);
        UsuarioModificarUseCase usuarioModificarUseCase = new UsuarioModificarUseCase(miUsuarioRepository);
        boolean resultado = usuarioModificarUseCase.modificarUsuario(unUsuario);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarUsuario_HayConflictoUsuarioExiste_UsuarioNoActualiza() {
        Usuario unUsuario = Usuario.instancia(1, "Cliente", "nombreusuario", "contrasenia", Sucursal.instancia(1, "Sucursal 1"));
        when(miUsuarioRepository.existeUsuario("Cliente")).thenReturn(true);
        when(miUsuarioRepository.guardarUsuario(unUsuario)).thenReturn(false);
        UsuarioModificarUseCase usuarioModificarUseCase = new UsuarioModificarUseCase(miUsuarioRepository);
        Assertions.assertThrows(UsuarioExisteException.class, () -> usuarioModificarUseCase.modificarUsuario(unUsuario));
    }
}
