package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Ubicacion;
import com.ar.genesis.sistema.core.input.IObtenerUbicacionesInput;
import com.ar.genesis.sistema.core.repository.IObtenerUbicacionesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ObtenerUbicacionesUseCase implements IObtenerUbicacionesInput {

    IObtenerUbicacionesRepository iObtenerUbicacionesRepository;

    public ObtenerUbicacionesUseCase(IObtenerUbicacionesRepository iObtenerUbicacionesRepository) {
        this.iObtenerUbicacionesRepository = iObtenerUbicacionesRepository;
    }

    @Override
    public List<Ubicacion> obtenerUbicaciones() {
        return iObtenerUbicacionesRepository.obtenerUbicaciones();
    }
}
