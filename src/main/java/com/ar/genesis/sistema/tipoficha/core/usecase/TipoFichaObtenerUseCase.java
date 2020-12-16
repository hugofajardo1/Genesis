package com.ar.genesis.sistema.tipoficha.core.usecase;

import com.ar.genesis.sistema.tipoficha.core.domain.TipoFicha;
import com.ar.genesis.sistema.tipoficha.core.input.ITipoFichaObtenerInput;
import com.ar.genesis.sistema.tipoficha.core.repository.ITipoFichaObtenerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TipoFichaObtenerUseCase implements ITipoFichaObtenerInput {

    ITipoFichaObtenerRepository miTipoFichaObtenerRepository;

    public TipoFichaObtenerUseCase(ITipoFichaObtenerRepository miTipoFichaObtenerRepository) { this.miTipoFichaObtenerRepository = miTipoFichaObtenerRepository; }

    @Override
    public List<TipoFicha> obtenerTipoFichas() {
        return miTipoFichaObtenerRepository.obtenerTipoFichas();
    }
}
