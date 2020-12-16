package com.ar.genesis.sistema.tipounidad.core.usecase;

import com.ar.genesis.sistema.tipounidad.core.domain.TipoUnidad;
import com.ar.genesis.sistema.tipounidad.core.input.ITipoUnidadObtenerInput;
import com.ar.genesis.sistema.tipounidad.core.repository.ITipoUnidadObtenerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TipoUnidadObtenerUseCase implements ITipoUnidadObtenerInput {

    ITipoUnidadObtenerRepository miTipoUnidadObtenerRepository;

    public TipoUnidadObtenerUseCase(ITipoUnidadObtenerRepository miTipoUnidadObtenerRepository) { this.miTipoUnidadObtenerRepository = miTipoUnidadObtenerRepository; }

    @Override
    public List<TipoUnidad> obtenerTipoUnidades() {
        return miTipoUnidadObtenerRepository.obtenerTipoUnidades();
    }
}
