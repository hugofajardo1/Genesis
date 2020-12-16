package com.ar.genesis.sistema.localidad.core.usecase;

import com.ar.genesis.sistema.localidad.core.domain.Localidad;
import com.ar.genesis.sistema.localidad.core.exception.LocalidadExisteException;
import com.ar.genesis.sistema.localidad.core.input.ILocalidadModificarInput;
import com.ar.genesis.sistema.localidad.core.repository.ILocalidadRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LocalidadModificarUseCase implements ILocalidadModificarInput {

    ILocalidadRepository miLocalidadRepository;

    public LocalidadModificarUseCase(ILocalidadRepository miLocalidadRepository) { this.miLocalidadRepository = miLocalidadRepository; }

    @Override
    public boolean modificarLocalidad(Localidad unaLocalidad) throws LocalidadExisteException {
        if(miLocalidadRepository.existeLocalidad(unaLocalidad.getNombre())){
            throw new LocalidadExisteException();
        }
        return miLocalidadRepository.guardarLocalidad(unaLocalidad);
    }
}
