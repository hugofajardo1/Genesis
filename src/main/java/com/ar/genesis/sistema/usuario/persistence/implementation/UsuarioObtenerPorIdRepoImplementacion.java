package com.ar.genesis.sistema.usuario.persistence.implementation;

import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import com.ar.genesis.sistema.usuario.core.repository.IUsuarioObtenerPorIdRepository;
import com.ar.genesis.sistema.usuario.persistence.crud.IUsuarioCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class UsuarioObtenerPorIdRepoImplementacion implements IUsuarioObtenerPorIdRepository {
    @Inject
    IUsuarioCRUD miUsuarioCRUD;

    @Override
    public Usuario obtenerUsuario(Integer id) { return miUsuarioCRUD.findUsuarioByIdEquals(id); }
}
