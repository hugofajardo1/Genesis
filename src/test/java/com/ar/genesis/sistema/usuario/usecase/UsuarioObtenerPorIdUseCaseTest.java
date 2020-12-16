package com.ar.genesis.sistema.usuario.usecase;

import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import com.ar.genesis.sistema.usuario.core.exception.UsuarioNoExisteException;
import com.ar.genesis.sistema.usuario.core.repository.IUsuarioObtenerPorIdRepository;
import com.ar.genesis.sistema.usuario.core.usecase.UsuarioObtenerPorIdUseCase;
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
        Usuario unUsuario = Usuario.instancia(1, "Usuario 1", "nombreusuario", "contrasenia", Sucursal.instancia(1, "Sucursal 1"));

        when(miUsuarioObtenerPorIdRepository.obtenerUsuario(1)).thenReturn(unUsuario);

        UsuarioObtenerPorIdUseCase usuarioObtenerPorIdUseCase = new UsuarioObtenerPorIdUseCase(miUsuarioObtenerPorIdRepository);
        Usuario resultado = usuarioObtenerPorIdUseCase.obtenerUsuario(1);
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerUsuarioPorNombreUsuarioYContrasenia_devuelveUsuarioNoExiste() {

        when(miUsuarioObtenerPorIdRepository.obtenerUsuario(1)).thenReturn(null);

        UsuarioObtenerPorIdUseCase usuarioObtenerPorIdUseCase = new UsuarioObtenerPorIdUseCase(miUsuarioObtenerPorIdRepository);
        Assertions.assertThrows(UsuarioNoExisteException.class, () -> usuarioObtenerPorIdUseCase.obtenerUsuario(1));
    }
}