package com.ar.genesis.sistema.permisousuarioTest.usecase;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;
import com.ar.genesis.sistema.permisousuario.core.exception.PermisoUsuarioNoExisteException;
import com.ar.genesis.sistema.permisousuario.core.repository.IPermisoUsuarioObtenerPorIdRepository;
import com.ar.genesis.sistema.permisousuario.core.usecase.PermisoUsuarioObtenerPorIdUseCase;
import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class PermisoUsuarioObtenerPorIdUseCaseTest {
    @Mock
    IPermisoUsuarioObtenerPorIdRepository miPermisoUsuarioObtenerPorIdRepository;

    @Test
    public void obtenerPermisoUsuarioPorId_devuelvePermisoUsuario() throws PermisoUsuarioNoExisteException {
        PermisoUsuario unPermisoUsuario = PermisoUsuario.instancia(1, Permiso.instancia(1,"Permiso 1"), Usuario.instancia(1, "Usuario 1", "nombreusuario", "contrasenia", Sucursal.instancia(1, "Sucursal 1")));

        when(miPermisoUsuarioObtenerPorIdRepository.obtenerPermisoUsuario(1)).thenReturn(unPermisoUsuario);

        PermisoUsuarioObtenerPorIdUseCase permisousuarioObtenerPorIdUseCase = new PermisoUsuarioObtenerPorIdUseCase(miPermisoUsuarioObtenerPorIdRepository);
        PermisoUsuario resultado = permisousuarioObtenerPorIdUseCase.obtenerPermisoUsuario(1);
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerPermisoUsuarioPorId_devuelvePermisoUsuarioNoExiste() {

        when(miPermisoUsuarioObtenerPorIdRepository.obtenerPermisoUsuario(1)).thenReturn(null);

        PermisoUsuarioObtenerPorIdUseCase permisousuarioObtenerPorIdUseCase = new PermisoUsuarioObtenerPorIdUseCase(miPermisoUsuarioObtenerPorIdRepository);
        Assertions.assertThrows(PermisoUsuarioNoExisteException.class, () -> permisousuarioObtenerPorIdUseCase.obtenerPermisoUsuario(1));
    }
}