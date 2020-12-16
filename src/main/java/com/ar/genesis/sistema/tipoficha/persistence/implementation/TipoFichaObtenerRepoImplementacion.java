package com.ar.genesis.sistema.tipoficha.persistence.implementation;

import com.ar.genesis.sistema.tipoficha.core.domain.TipoFicha;
import com.ar.genesis.sistema.tipoficha.core.repository.ITipoFichaObtenerRepository;
import com.ar.genesis.sistema.tipoficha.persistence.crud.ITipoFichaCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class TipoFichaObtenerRepoImplementacion implements ITipoFichaObtenerRepository {
    @Inject
    ITipoFichaCRUD miTipoFichaCRUD;

    @Override
    public List<TipoFicha> obtenerTipoFichas() {
        return miTipoFichaCRUD.findAllByOrderById();
    }
}
