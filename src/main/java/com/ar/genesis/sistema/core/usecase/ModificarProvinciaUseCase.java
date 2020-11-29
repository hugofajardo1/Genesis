package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Provincia;
import com.ar.genesis.sistema.core.exception.ProvinciaExisteException;
import com.ar.genesis.sistema.core.input.IModificarProvinciaInput;
import com.ar.genesis.sistema.core.repository.IProvinciaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ModificarProvinciaUseCase implements IModificarProvinciaInput {

    IProvinciaRepository iProvinciaRepository;

    public ModificarProvinciaUseCase(IProvinciaRepository iProvinciaRepository) {
        this.iProvinciaRepository = iProvinciaRepository;
    }

    @Override
    public boolean modificarProvincia(Provincia unaProvincia) throws ProvinciaExisteException {
        if(iProvinciaRepository.existeProvincia(unaProvincia.getNombre())){
            throw new ProvinciaExisteException();
        }
        return iProvinciaRepository.guardarProvincia(unaProvincia);
    }
}
