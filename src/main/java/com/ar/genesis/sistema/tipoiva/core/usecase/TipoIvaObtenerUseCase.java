package com.ar.genesis.sistema.tipoiva.core.usecase;

import com.ar.genesis.sistema.tipoiva.core.domain.TipoIva;
import com.ar.genesis.sistema.tipoiva.core.input.ITipoIvaObtenerInput;
import com.ar.genesis.sistema.tipoiva.core.repository.ITipoIvaObtenerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TipoIvaObtenerUseCase implements ITipoIvaObtenerInput {

    ITipoIvaObtenerRepository miTipoIvaObtenerRepository;

    public TipoIvaObtenerUseCase(ITipoIvaObtenerRepository miTipoIvaObtenerRepository) { this.miTipoIvaObtenerRepository = miTipoIvaObtenerRepository; }

    @Override
    public List<TipoIva> obtenerTipoIvas() {
        return miTipoIvaObtenerRepository.obtenerTipoIvas();
    }
}
