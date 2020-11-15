package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.TipoCliente;
import com.ar.genesis.sistema.core.repository.ITipoClienteRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.ITipoClienteCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class TipoClienteRepoImplementacion implements ITipoClienteRepository {

    @Inject
    ITipoClienteCRUD tipoClienteCRUD;

    @Override
    public boolean existeTipoCliente(String nombre) { return tipoClienteCRUD.existsByNombre(nombre); }

    @Override
    public boolean guardarTipoCliente(TipoCliente unTipoCliente) { return tipoClienteCRUD.save(unTipoCliente).getId()!=null; }
}
