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

    ILocalidadRepository miLocalidadRepository;

    public CrearLocalidadUseCase(ILocalidadRepository miLocalidadRepository) { this.miLocalidadRepository = miLocalidadRepository; }

    @Override
    public boolean crearLocalidad(Localidad unaLocalidad) throws LocalidadExisteException {
        if(miLocalidadRepository.existeLocalidad(unaLocalidad.getNombre())){
            throw new LocalidadExisteException();
        }
        return miLocalidadRepository.guardarLocalidad(unaLocalidad);
    }
}
