package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.SubRubro;
import com.ar.genesis.sistema.core.exception.SubRubroExisteException;
import com.ar.genesis.sistema.core.input.ICrearSubRubroInput;
import com.ar.genesis.sistema.core.repository.ISubRubroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SubRubroCrearUseCase implements ICrearSubRubroInput {

    ISubRubroRepository miSubRubroRepository;

    public SubRubroCrearUseCase(ISubRubroRepository miSubRubroRepository) { this.miSubRubroRepository = miSubRubroRepository; }

    @Override
    public boolean crearSubRubro(SubRubro unSubRubro) throws SubRubroExisteException {
        if(miSubRubroRepository.existeSubRubro(unSubRubro.getNombre())){
            throw new SubRubroExisteException();
        }
        return miSubRubroRepository.guardarSubRubro(unSubRubro);
    }
}
