package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Usuario;
import com.ar.genesis.sistema.core.repository.IUsuarioObtenerPorNombreUsuarioYContraseniaRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.IUsuarioCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class UsuarioObtenerPorNombreUsuarioYContraseniaRepoImplmentacion implements IUsuarioObtenerPorNombreUsuarioYContraseniaRepository {
    @Inject
    IUsuarioCRUD miUsuarioCRUD;

    @Override
    public Usuario obtenerUsuario(String nombreUsuario, String contrasenia) { return miUsuarioCRUD.findByNombreUsuarioEqualsAndContraseniaEquals(nombreUsuario, contrasenia); }
}
