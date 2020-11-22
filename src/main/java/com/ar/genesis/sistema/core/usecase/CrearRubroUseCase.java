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

    IRubroRepository iRubroRepository;

    public CrearRubroUseCase(IRubroRepository iRubroRepository) {
        this.iRubroRepository = iRubroRepository;
    }

    @Override
    public boolean crearRubro(Rubro unRubro) throws RubroExisteException {
        if(iRubroRepository.existeRubro(unRubro.getNombre())){
            throw new RubroExisteException();
        }
        return iRubroRepository.guardarRubro(unRubro);
    }
}
