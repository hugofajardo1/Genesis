package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Ubicacion;
import com.ar.genesis.sistema.core.exception.UbicacionExisteException;
import com.ar.genesis.sistema.core.input.IUbicacionCrearInput;
import com.ar.genesis.sistema.core.repository.IUbicacionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UbicacionUseCaseCrear implements IUbicacionCrearInput {

    IUbicacionRepository miUbicacionRepository;

    public UbicacionUseCaseCrear(IUbicacionRepository miUbicacionRepository) { this.miUbicacionRepository = miUbicacionRepository; }

    @Override
    public boolean crearUbicacion(Ubicacion unaUbicacion) throws UbicacionExisteException {
        if(miUbicacionRepository.existeUbicacion(unaUbicacion.getNombre())){
            throw new UbicacionExisteException();
        }
        return miUbicacionRepository.guardarUbicacion(unaUbicacion);
    }
}
