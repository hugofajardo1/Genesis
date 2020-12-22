package com.ar.genesis.sistema.permisousuarioTest.usecase;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;
import com.ar.genesis.sistema.permisousuario.core.exception.PermisoUsuarioExisteException;
import com.ar.genesis.sistema.permisousuario.core.exception.PermisoUsuarioNoExisteException;
import com.ar.genesis.sistema.permisousuario.core.repository.IPermisoUsuarioEliminarRepository;
import com.ar.genesis.sistema.permisousuario.core.usecase.PermisoUsuarioEliminarUseCase;
import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class PermisoUsuarioEliminarUseCaseTest {
    @Mock
    IPermisoUsuarioEliminarRepository miPermisoUsuarioEliminarRepository;
    @Test
    void eliminarPermisoUsuario_PermisoUsuarioEliminadoCorrectamente() throws PermisoUsuarioNoExisteException {
        PermisoUsuario unPermisoUsuario = PermisoUsuario.instancia(1, Permiso.instancia(1,"Permiso 1"), Usuario.instancia(1, "Usuario 1", "nombreusuario", "contrasenia", Sucursal.instancia(1, "Sucursal 1")));
        when(miPermisoUsuarioEliminarRepository.existePermisoUsuario(unPermisoUsuario)).thenReturn(true);
        when(miPermisoUsuarioEliminarRepository.eliminarPermisoUsuario(unPermisoUsuario)).thenReturn(true);
        PermisoUsuarioEliminarUseCase permisousuarioEliminarUseCase = new PermisoUsuarioEliminarUseCase(miPermisoUsuarioEliminarRepository);
        boolean resultado = permisousuarioEliminarUseCase.eliminarPermisoUsuario(unPermisoUsuario);
        Assertions.assertTrue(resultado);
    }

    @Test
    void eliminarPermisoUsuario_HayConflictoPermisoUsuarioNoExiste_PermisoUsuarioNoEliminado() {
        PermisoUsuario unPermisoUsuario = PermisoUsuario.instancia(1, Permiso.instancia(1,"Permiso 1"), Usuario.instancia(1, "Usuario 1", "nombreusuario", "contrasenia", Sucursal.instancia(1, "Sucursal 1")));
        when(miPermisoUsuarioEliminarRepository.existePermisoUsuario(unPermisoUsuario)).thenReturn(false);
        when(miPermisoUsuarioEliminarRepository.eliminarPermisoUsuario(unPermisoUsuario)).thenReturn(false);
        PermisoUsuarioEliminarUseCase permisousuarioEliminarUseCase = new PermisoUsuarioEliminarUseCase(miPermisoUsuarioEliminarRepository);
        Assertions.assertThrows(PermisoUsuarioNoExisteException.class, () -> permisousuarioEliminarUseCase.eliminarPermisoUsuario(unPermisoUsuario));
    }
}
