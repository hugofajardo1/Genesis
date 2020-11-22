package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.SubRubro;
import com.ar.genesis.sistema.core.exception.SubRubroExisteException;
import com.ar.genesis.sistema.core.input.IModificarSubRubroInput;
import com.ar.genesis.sistema.core.repository.ISubRubroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ModificarSubRubroUseCase implements IModificarSubRubroInput {

    ISubRubroRepository iSubRubroRepository;

    public ModificarSubRubroUseCase(ISubRubroRepository iSubRubroRepository) {
        this.iSubRubroRepository = iSubRubroRepository;
    }

    @Override
    public boolean modificarSubRubro(SubRubro unSubRubro) throws SubRubroExisteException {
        if(iSubRubroRepository.existeSubRubro(unSubRubro.getNombre())){
            throw new SubRubroExisteException();
        }
        return iSubRubroRepository.guardarSubRubro(unSubRubro);
    }
}
