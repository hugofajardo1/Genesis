package com.ar.genesis.sistema.tipooperacion.core.usecase;

import com.ar.genesis.sistema.tipooperacion.core.domain.TipoOperacion;
import com.ar.genesis.sistema.tipooperacion.core.input.ITipoOperacionObtenerInput;
import com.ar.genesis.sistema.tipooperacion.core.repository.ITipoOperacionObtenerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TipoOperacionObtenerUseCase implements ITipoOperacionObtenerInput {

    ITipoOperacionObtenerRepository miTipoOperacionObtenerRepository;

    public TipoOperacionObtenerUseCase(ITipoOperacionObtenerRepository miTipoOperacionObtenerRepository) { this.miTipoOperacionObtenerRepository = miTipoOperacionObtenerRepository; }

    @Override
    public List<TipoOperacion> obtenerTipoOperaciones() {
        return miTipoOperacionObtenerRepository.obtenerTipoOperaciones();
    }
}
