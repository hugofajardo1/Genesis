package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.core.input.ITipoFichaObtenerInput;
import com.ar.genesis.sistema.core.repository.ITipoFichaObtenerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TipoFichaUseCase implements ITipoFichaObtenerInput {

    ITipoFichaObtenerRepository miTipoFichaObtenerRepository;

    public TipoFichaUseCase(ITipoFichaObtenerRepository miTipoFichaObtenerRepository) { this.miTipoFichaObtenerRepository = miTipoFichaObtenerRepository; }

    @Override
    public List<TipoFicha> obtenerTipoFichas() {
        return miTipoFichaObtenerRepository.obtenerTipoFichas();
    }
}
