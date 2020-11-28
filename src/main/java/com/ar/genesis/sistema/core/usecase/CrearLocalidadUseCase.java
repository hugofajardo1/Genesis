package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Localidad;
import com.ar.genesis.sistema.core.exception.LocalidadExisteException;
import com.ar.genesis.sistema.core.input.ICrearLocalidadInput;
import com.ar.genesis.sistema.core.repository.ILocalidadRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CrearLocalidadUseCase implements ICrearLocalidadInput {

    ILocalidadRepository iLocalidadRepository;

    public CrearLocalidadUseCase(ILocalidadRepository iLocalidadRepository) {
        this.iLocalidadRepository = iLocalidadRepository;
    }

    @Override
    public boolean crearLocalidad(Localidad localidad) throws LocalidadExisteException {
        if(iLocalidadRepository.existeLocalidad(localidad.getNombre())){
            throw new LocalidadExisteException();
        }
        return iLocalidadRepository.guardarLocalidad(localidad);
    }
}
