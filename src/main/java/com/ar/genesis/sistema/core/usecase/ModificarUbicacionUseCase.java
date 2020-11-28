package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Ubicacion;
import com.ar.genesis.sistema.core.exception.UbicacionExisteException;
import com.ar.genesis.sistema.core.input.IModificarUbicacionInput;
import com.ar.genesis.sistema.core.repository.IUbicacionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ModificarUbicacionUseCase implements IModificarUbicacionInput {

    IUbicacionRepository iUbicacionRepository;

    public ModificarUbicacionUseCase(IUbicacionRepository iUbicacionRepository) {
        this.iUbicacionRepository = iUbicacionRepository;
    }

    @Override
    public boolean modificarUbicacion(Ubicacion unaUbicacion) throws UbicacionExisteException {
        if(iUbicacionRepository.existeUbicacion(unaUbicacion.getNombre())){
            throw new UbicacionExisteException();
        }
        return iUbicacionRepository.guardarUbicacion(unaUbicacion);
    }
}
