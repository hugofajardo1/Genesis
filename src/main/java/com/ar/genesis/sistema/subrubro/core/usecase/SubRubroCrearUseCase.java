package com.ar.genesis.sistema.subrubro.core.usecase;

import com.ar.genesis.sistema.subrubro.core.domain.SubRubro;
import com.ar.genesis.sistema.subrubro.core.exception.SubRubroExisteException;
import com.ar.genesis.sistema.subrubro.core.input.ISubRubroCrearInput;
import com.ar.genesis.sistema.subrubro.core.repository.ISubRubroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SubRubroCrearUseCase implements ISubRubroCrearInput {

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
