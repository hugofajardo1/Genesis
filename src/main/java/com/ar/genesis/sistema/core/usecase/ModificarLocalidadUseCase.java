package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Localidad;
import com.ar.genesis.sistema.core.exception.LocalidadExisteException;
import com.ar.genesis.sistema.core.input.IModificarLocalidadInput;
import com.ar.genesis.sistema.core.repository.ILocalidadRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ModificarLocalidadUseCase implements IModificarLocalidadInput {

    ILocalidadRepository iLocalidadRepository;

    public ModificarLocalidadUseCase(ILocalidadRepository iLocalidadRepository) {
        this.iLocalidadRepository = iLocalidadRepository;
    }

    @Override
    public boolean modificarLocalidad(Localidad unaLocalidad) throws LocalidadExisteException {
        if(iLocalidadRepository.existeLocalidad(unaLocalidad.getNombre())){
            throw new LocalidadExisteException();
        }
        return iLocalidadRepository.guardarLocalidad(unaLocalidad);
    }
}