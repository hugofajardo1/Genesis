package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Rubro;
import com.ar.genesis.sistema.core.exception.RubroExisteException;
import com.ar.genesis.sistema.core.input.ICrearRubroInput;
import com.ar.genesis.sistema.core.repository.IRubroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CrearRubroUseCase implements ICrearRubroInput {

    IRubroRepository miRubroRepository;

    public CrearRubroUseCase(IRubroRepository miRubroRepository) {
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
