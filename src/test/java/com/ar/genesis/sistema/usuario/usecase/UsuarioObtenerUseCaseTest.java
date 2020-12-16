package com.ar.genesis.sistema.usuario.usecase;

import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import com.ar.genesis.sistema.usuario.core.repository.IUsuarioObtenerRepository;
import com.ar.genesis.sistema.usuario.core.usecase.UsuarioObtenerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class UsuarioObtenerUseCaseTest {
    @Mock
    IUsuarioObtenerRepository miUsuarioObtenerRepository;
    @Spy
    List<Usuario> usuarios = factoryListaUsuarios();

    @Test
    public void obtenerUsuarios_devuelveLista(){
        when(miUsuarioObtenerRepository.obtenerUsuarios()).thenReturn(usuarios);
        UsuarioObtenerUseCase usuarioObtenerUseCase = new UsuarioObtenerUseCase(miUsuarioObtenerRepository);
        List<Usuario> resultado = usuarioObtenerUseCase.obtenerUsuarios();
        Assertions.assertEquals(2,resultado.size());
    }

    public List<Usuario> factoryListaUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario1 = Usuario.instancia(1, "Usuario 1", "nombreusuario", "contrasenia", Sucursal.instancia(1, "Sucursal 1"));
        Usuario usuario2 = Usuario.instancia(2, "Usuario 2", "nombreusuario", "contrasenia", Sucursal.instancia(1, "Sucursal 1"));
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        return usuarios;
    }
}
