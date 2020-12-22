package com.ar.genesis.sistema.permisousuarioTest.usecase;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;
import com.ar.genesis.sistema.permisousuario.core.exception.PermisoUsuarioExisteException;
import com.ar.genesis.sistema.permisousuario.core.repository.IPermisoUsuarioRepository;
import com.ar.genesis.sistema.permisousuario.core.usecase.PermisoUsuarioModificarUseCase;
import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class PermisoUsuarioModificarUseCaseTest {
    @Mock
    IPermisoUsuarioRepository miPermisoUsuarioRepository;
    @Test
    void modificarPermisoUsuario_PermisoUsuarioActualizadoCorrectamente() throws PermisoUsuarioExisteException {
        PermisoUsuario unPermisoUsuario = PermisoUsuario.instancia(1, Permiso.instancia(1,"Permiso 1"), Usuario.instancia(1, "Usuario 1", "nombreusuario", "contrasenia", Sucursal.instancia(1, "Sucursal 1")));
        when(miPermisoUsuarioRepository.existePermisoUsuario(unPermisoUsuario)).thenReturn(false);
        when(miPermisoUsuarioRepository.guardarPermisoUsuario(unPermisoUsuario)).thenReturn(true);
        PermisoUsuarioModificarUseCase permisousuarioModificarUseCase = new PermisoUsuarioModificarUseCase(miPermisoUsuarioRepository);
        boolean resultado = permisousuarioModificarUseCase.modificarPermisoUsuario(unPermisoUsuario);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarPermisoUsuario_HayConflictoPermisoUsuarioExiste_PermisoUsuarioNoActualiza() {
        PermisoUsuario unPermisoUsuario = PermisoUsuario.instancia(1, Permiso.instancia(1,"Permiso 1"), Usuario.instancia(1, "Usuario 1", "nombreusuario", "contrasenia", Sucursal.instancia(1, "Sucursal 1")));
        when(miPermisoUsuarioRepository.existePermisoUsuario(unPermisoUsuario)).thenReturn(true);
        when(miPermisoUsuarioRepository.guardarPermisoUsuario(unPermisoUsuario)).thenReturn(false);
        PermisoUsuarioModificarUseCase permisousuarioModificarUseCase = new PermisoUsuarioModificarUseCase(miPermisoUsuarioRepository);
        Assertions.assertThrows(PermisoUsuarioExisteException.class, () -> permisousuarioModificarUseCase.modificarPermisoUsuario(unPermisoUsuario));
    }
}
