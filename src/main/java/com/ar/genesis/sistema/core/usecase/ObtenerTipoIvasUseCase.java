package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.core.input.IObtenerTipoIvasInput;
import com.ar.genesis.sistema.core.repository.IObtenerTipoIvasRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ObtenerTipoIvasUseCase implements IObtenerTipoIvasInput {

    IObtenerTipoIvasRepository miObtenerTipoIvasRepository;

    public ObtenerTipoIvasUseCase(IObtenerTipoIvasRepository miObtenerTipoIvasRepository) { this.miObtenerTipoIvasRepository = miObtenerTipoIvasRepository; }

    @Override
    public List<TipoIva> obtenerTipoIvas() {
        return miObtenerTipoIvasRepository.obtenerTipoIvas();
    }
}
