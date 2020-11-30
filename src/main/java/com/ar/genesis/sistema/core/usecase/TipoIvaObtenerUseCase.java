package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.core.input.IObtenerTipoIvasInput;
import com.ar.genesis.sistema.core.repository.ITipoIvaObtenerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TipoIvaObtenerUseCase implements IObtenerTipoIvasInput {

    ITipoIvaObtenerRepository miTipoIvaObtenerRepository;

    public TipoIvaObtenerUseCase(ITipoIvaObtenerRepository miTipoIvaObtenerRepository) { this.miTipoIvaObtenerRepository = miTipoIvaObtenerRepository; }

    @Override
    public List<TipoIva> obtenerTipoIvas() {
        return miTipoIvaObtenerRepository.obtenerTipoIvas();
    }
}
