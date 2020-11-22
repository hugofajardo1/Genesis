package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.SubRubro;
import com.ar.genesis.sistema.core.exception.SubRubroExisteException;
import com.ar.genesis.sistema.core.input.ICrearSubRubroInput;
import com.ar.genesis.sistema.core.repository.ISubRubroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CrearSubRubroUseCase implements ICrearSubRubroInput {

    ISubRubroRepository iSubRubroRepository;

    public CrearSubRubroUseCase(ISubRubroRepository iSubRubroRepository) {
        this.iSubRubroRepository = iSubRubroRepository;
    }

    @Override
    public boolean crearSubRubro(SubRubro unSubRubro) throws SubRubroExisteException {
        if(iSubRubroRepository.existeSubRubro(unSubRubro.getNombre())){
            throw new SubRubroExisteException();
        }
        return iSubRubroRepository.guardarSubRubro(unSubRubro);
    }
}
