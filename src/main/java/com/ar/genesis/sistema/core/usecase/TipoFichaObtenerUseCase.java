package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.core.input.IObtenerTipoFichasInput;
import com.ar.genesis.sistema.core.repository.ITipoFichaObtenerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TipoFichaObtenerUseCase implements IObtenerTipoFichasInput {

    ITipoFichaObtenerRepository miTipoFichaObtenerRepository;

    public TipoFichaObtenerUseCase(ITipoFichaObtenerRepository miTipoFichaObtenerRepository) { this.miTipoFichaObtenerRepository = miTipoFichaObtenerRepository; }

    @Override
    public List<TipoFicha> obtenerTipoFichas() {
        return miTipoFichaObtenerRepository.obtenerTipoFichas();
    }
}
