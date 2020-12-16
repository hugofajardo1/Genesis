package com.ar.genesis.sistema.rubro.core.usecase;

import com.ar.genesis.sistema.rubro.core.domain.Rubro;
import com.ar.genesis.sistema.rubro.core.exception.RubroExisteException;
import com.ar.genesis.sistema.rubro.core.input.IRubroCrearInput;
import com.ar.genesis.sistema.rubro.core.repository.IRubroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RubroCrearUseCase implements IRubroCrearInput {

    IRubroRepository miRubroRepository;

    public RubroCrearUseCase(IRubroRepository miRubroRepository) {
        this.miRubroRepository = miRubroRepository;
    }

    @Override
    public boolean crearRubro(Rubro unRubro) throws RubroExisteException {
        if(miRubroRepository.existeRubro(unRubro.getNombre())){
            throw new RubroExisteException();
        }
        return miRubroRepository.guardarRubro(unRubro);
    }
}
