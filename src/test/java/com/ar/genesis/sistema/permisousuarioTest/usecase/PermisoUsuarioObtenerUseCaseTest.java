package com.ar.genesis.sistema.permisousuarioTest.usecase;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;
import com.ar.genesis.sistema.permisousuario.core.repository.IPermisoUsuarioObtenerRepository;
import com.ar.genesis.sistema.permisousuario.core.usecase.PermisoUsuarioObtenerUseCase;
import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class PermisoUsuarioObtenerUseCaseTest {
    @Mock
    IPermisoUsuarioObtenerRepository miPermisoUsuarioObtenerRepository;
    @Spy
    List<PermisoUsuario> permisoUsuarios = factoryListaPermisoUsuarios();

    @Test
    public void obtenerPermisoUsuarios_devuelveLista(){
        when(miPermisoUsuarioObtenerRepository.obtenerPermisoUsuarios()).thenReturn(permisoUsuarios);
        PermisoUsuarioObtenerUseCase permisousuarioObtenerUseCase = new PermisoUsuarioObtenerUseCase(miPermisoUsuarioObtenerRepository);
        List<PermisoUsuario> resultado = permisousuarioObtenerUseCase.obtenerPermisoUsuarios();
        Assertions.assertEquals(2,resultado.size());
    }

    public List<PermisoUsuario> factoryListaPermisoUsuarios() {
        List<PermisoUsuario> permisousuarios = new ArrayList<>();
        PermisoUsuario permisousuario1 = PermisoUsuario.instancia(1, Permiso.instancia(1,"Permiso 1"), Usuario.instancia(1, "Usuario 1", "nombreusuario", "contrasenia", Sucursal.instancia(1, "Sucursal 1")));
        PermisoUsuario permisousuario2 = PermisoUsuario.instancia(2, Permiso.instancia(2,"Permiso 2"), Usuario.instancia(1, "Usuario 1", "nombreusuario", "contrasenia", Sucursal.instancia(1, "Sucursal 1")));
        permisousuarios.add(permisousuario1);
        permisousuarios.add(permisousuario2);
        return permisousuarios;
    }
}
