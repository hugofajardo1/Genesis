package com.ar.genesis.sistema.ubicacion.core.usecase;

import com.ar.genesis.sistema.ubicacion.core.domain.Ubicacion;
import com.ar.genesis.sistema.ubicacion.core.exception.UbicacionExisteException;
import com.ar.genesis.sistema.ubicacion.core.input.IUbicacionCrearInput;
import com.ar.genesis.sistema.ubicacion.core.repository.IUbicacionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UbicacionCrearUseCase implements IUbicacionCrearInput {

    IUbicacionRepository miUbicacionRepository;

    public UbicacionCrearUseCase(IUbicacionRepository miUbicacionRepository) { this.miUbicacionRepository = miUbicacionRepository; }

    @Override
    public boolean crearUbicacion(Ubicacion unaUbicacion) throws UbicacionExisteException {
        if(miUbicacionRepository.existeUbicacion(unaUbicacion.getNombre())){
            throw new UbicacionExisteException();
        }
        return miUbicacionRepository.guardarUbicacion(unaUbicacion);
    }
}
