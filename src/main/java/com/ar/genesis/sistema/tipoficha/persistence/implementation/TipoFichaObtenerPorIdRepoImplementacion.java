package com.ar.genesis.sistema.tipoficha.persistence.implementation;

import com.ar.genesis.sistema.tipoficha.core.domain.TipoFicha;
import com.ar.genesis.sistema.tipoficha.core.repository.ITipoFichaObtenerPorIdRepository;
import com.ar.genesis.sistema.tipoficha.persistence.crud.ITipoFichaCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class TipoFichaObtenerPorIdRepoImplementacion implements ITipoFichaObtenerPorIdRepository {
    @Inject
    ITipoFichaCRUD miTipoFichaCRUD;

    @Override
    public TipoFicha obtenerTipoFicha(Integer id) { return miTipoFichaCRUD.findTipoFichaByIdEquals(id); }
}
