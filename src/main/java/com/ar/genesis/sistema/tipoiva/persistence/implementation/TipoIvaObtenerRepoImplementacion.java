package com.ar.genesis.sistema.tipoiva.persistence.implementation;

import com.ar.genesis.sistema.tipoiva.core.domain.TipoIva;
import com.ar.genesis.sistema.tipoiva.core.repository.ITipoIvaObtenerRepository;
import com.ar.genesis.sistema.tipoiva.persistence.crud.ITipoIvaCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class TipoIvaObtenerRepoImplementacion implements ITipoIvaObtenerRepository {
    @Inject
    ITipoIvaCRUD miTipoIvaCRUD;

    @Override
    public List<TipoIva> obtenerTipoIvas() {
        return miTipoIvaCRUD.findAllByOrderById();
    }
}
