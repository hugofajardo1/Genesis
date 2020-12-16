package com.ar.genesis.sistema.provincia.core.usecase;

import com.ar.genesis.sistema.provincia.core.domain.Provincia;
import com.ar.genesis.sistema.provincia.core.exception.ProvinciaExisteException;
import com.ar.genesis.sistema.provincia.core.input.IProvinciaModificarInput;
import com.ar.genesis.sistema.provincia.core.repository.IProvinciaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProvinciaModificarUseCase implements IProvinciaModificarInput {

    IProvinciaRepository miProvinciaRepository;

    public ProvinciaModificarUseCase(IProvinciaRepository miProvinciaRepository) { this.miProvinciaRepository = miProvinciaRepository; }

    @Override
    public boolean modificarProvincia(Provincia unaProvincia) throws ProvinciaExisteException {
        if(miProvinciaRepository.existeProvincia(unaProvincia.getNombre())){
            throw new ProvinciaExisteException();
        }
        return miProvinciaRepository.guardarProvincia(unaProvincia);
    }
}
