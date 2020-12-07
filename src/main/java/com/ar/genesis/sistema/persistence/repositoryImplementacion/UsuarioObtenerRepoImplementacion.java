package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Usuario;
import com.ar.genesis.sistema.core.repository.IUsuarioObtenerRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.IUsuarioCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class UsuarioObtenerRepoImplementacion implements IUsuarioObtenerRepository {
    @Inject
    IUsuarioCRUD miUsuarioCRUD;

    @Override
    public List<Usuario> obtenerUsuarios() {
        return miUsuarioCRUD.findAllByOrderById();
    }
}
