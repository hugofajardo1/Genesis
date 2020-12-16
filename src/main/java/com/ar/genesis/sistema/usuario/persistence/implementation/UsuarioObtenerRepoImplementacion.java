package com.ar.genesis.sistema.usuario.persistence.implementation;

import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import com.ar.genesis.sistema.usuario.core.repository.IUsuarioObtenerRepository;
import com.ar.genesis.sistema.usuario.persistence.crud.IUsuarioCRUD;
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
