package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Usuario;
import com.ar.genesis.sistema.core.repository.IUsuarioRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.IUsuarioCRUD;
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
