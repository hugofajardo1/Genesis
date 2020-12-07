package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Usuario;
import com.ar.genesis.sistema.core.repository.IUsuarioObtenerPorIdRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.IUsuarioCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class UsuarioObtenerPorIdRepoImplementacion implements IUsuarioObtenerPorIdRepository {
    @Inject
    IUsuarioCRUD miUsuarioCRUD;

    @Override
    public Usuario obtenerUsuario(Integer id) { return miUsuarioCRUD.findUsuarioByIdEquals(id); }
}
