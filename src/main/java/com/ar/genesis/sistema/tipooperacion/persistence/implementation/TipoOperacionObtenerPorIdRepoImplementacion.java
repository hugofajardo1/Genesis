package com.ar.genesis.sistema.tipooperacion.persistence.implementation;

import com.ar.genesis.sistema.tipooperacion.core.domain.TipoOperacion;
import com.ar.genesis.sistema.tipooperacion.core.repository.ITipoOperacionObtenerPorIdRepository;
import com.ar.genesis.sistema.tipooperacion.persistence.crud.ITipoOperacionCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class TipoOperacionObtenerPorIdRepoImplementacion implements ITipoOperacionObtenerPorIdRepository {
    @Inject
    ITipoOperacionCRUD miTipoOperacionCRUD;

    @Override
    public TipoOperacion obtenerTipoOperacion(Integer id) { return miTipoOperacionCRUD.findTipoOperacionByIdEquals(id); }
}
