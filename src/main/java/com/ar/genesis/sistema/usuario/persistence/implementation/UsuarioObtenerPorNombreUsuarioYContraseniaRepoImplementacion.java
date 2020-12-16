package com.ar.genesis.sistema.usuario.persistence.implementation;

import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import com.ar.genesis.sistema.usuario.core.repository.IUsuarioObtenerPorNombreUsuarioYContraseniaRepository;
import com.ar.genesis.sistema.usuario.persistence.crud.IUsuarioCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class UsuarioObtenerPorNombreUsuarioYContraseniaRepoImplementacion implements IUsuarioObtenerPorNombreUsuarioYContraseniaRepository {
    @Inject
    IUsuarioCRUD miUsuarioCRUD;

    @Override
    public Usuario obtenerUsuario(String nombreUsuario, String contrasenia) { return miUsuarioCRUD.findByNombreUsuarioEqualsAndContraseniaEquals(nombreUsuario, contrasenia); }
}
