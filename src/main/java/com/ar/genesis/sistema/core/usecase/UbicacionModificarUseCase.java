package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Ubicacion;
import com.ar.genesis.sistema.core.exception.UbicacionExisteException;
import com.ar.genesis.sistema.core.input.IUbicacionModificarInput;
import com.ar.genesis.sistema.core.repository.IUbicacionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UbicacionModificarUseCase implements IUbicacionModificarInput {

    IUbicacionRepository miUbicacionRepository;

    public UbicacionModificarUseCase(IUbicacionRepository miUbicacionRepository) { this.miUbicacionRepository = miUbicacionRepository; }

    @Override
    public boolean modificarUbicacion(Ubicacion unaUbicacion) throws UbicacionExisteException {
        if(miUbicacionRepository.existeUbicacion(unaUbicacion.getNombre())){
            throw new UbicacionExisteException();
        }
        return miUbicacionRepository.guardarUbicacion(unaUbicacion);
    }
}
