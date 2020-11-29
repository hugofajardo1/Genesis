package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.TipoUnidad;
import com.ar.genesis.sistema.core.input.IObtenerTipoUnidadesInput;
import com.ar.genesis.sistema.core.repository.IObtenerTipoUnidadesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TipoUnidadObtenerUseCase implements IObtenerTipoUnidadesInput {

    IObtenerTipoUnidadesRepository miObtenerTipoUnidadesRepository;

    public TipoUnidadObtenerUseCase(IObtenerTipoUnidadesRepository miObtenerTipoUnidadesRepository) { this.miObtenerTipoUnidadesRepository = miObtenerTipoUnidadesRepository; }

    @Override
    public List<TipoUnidad> obtenerTipoUnidades() {
        return miObtenerTipoUnidadesRepository.obtenerTipoUnidades();
    }
}
