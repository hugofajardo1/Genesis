package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.core.input.ITipoIvaObtenerInput;
import com.ar.genesis.sistema.core.repository.ITipoIvaObtenerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TipoIvaUseCase implements ITipoIvaObtenerInput {

    ITipoIvaObtenerRepository miTipoIvaObtenerRepository;

    public TipoIvaUseCase(ITipoIvaObtenerRepository miTipoIvaObtenerRepository) { this.miTipoIvaObtenerRepository = miTipoIvaObtenerRepository; }

    @Override
    public List<TipoIva> obtenerTipoIvas() {
        return miTipoIvaObtenerRepository.obtenerTipoIvas();
    }
}
