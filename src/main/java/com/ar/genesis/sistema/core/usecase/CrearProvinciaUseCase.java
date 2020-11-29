package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Provincia;
import com.ar.genesis.sistema.core.exception.ProvinciaExisteException;
import com.ar.genesis.sistema.core.input.ICrearProvinciaInput;
import com.ar.genesis.sistema.core.repository.IProvinciaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CrearProvinciaUseCase implements ICrearProvinciaInput {

    IProvinciaRepository iProvinciaRepository;

    public CrearProvinciaUseCase(IProvinciaRepository iProvinciaRepository) {
        this.iProvinciaRepository = iProvinciaRepository;
    }

    @Override
    public boolean crearProvincia(Provincia unaProvincia) throws ProvinciaExisteException {
        if(iProvinciaRepository.existeProvincia(unaProvincia.getNombre())){
            throw new ProvinciaExisteException();
        }
        return iProvinciaRepository.guardarProvincia(unaProvincia);
    }
}
