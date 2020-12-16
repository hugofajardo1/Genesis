package com.ar.genesis.sistema.usuario.persistence.implementation;

import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import com.ar.genesis.sistema.usuario.core.repository.IUsuarioRepository;
import com.ar.genesis.sistema.usuario.persistence.crud.IUsuarioCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class UsuarioRepoImplementacion implements IUsuarioRepository {

    @Inject
    IUsuarioCRUD miUsuarioCRUD;

    @Override
    public boolean existeUsuario(String nombre) { return miUsuarioCRUD.existsByNombre(nombre); }

    @Override
    public boolean guardarUsuario(Usuario unUsuario) { return miUsuarioCRUD.save(unUsuario).getId()!=null; }
}
