package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Ubicacion;
import com.ar.genesis.sistema.core.exception.UbicacionExisteException;
import com.ar.genesis.sistema.core.input.ICrearUbicacionInput;
import com.ar.genesis.sistema.core.repository.IUbicacionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CrearUbicacionUseCase implements ICrearUbicacionInput {

    IUbicacionRepository iUbicacionRepository;

    public CrearUbicacionUseCase(IUbicacionRepository iUbicacionRepository) {
        this.iUbicacionRepository = iUbicacionRepository;
    }

    @Override
    public boolean crearUbicacion(Ubicacion ubicacion) throws UbicacionExisteException {
        if(iUbicacionRepository.existeUbicacion(ubicacion.getNombre())){
            throw new UbicacionExisteException();
        }
        return iUbicacionRepository.guardarUbicacion(ubicacion);
    }
}
