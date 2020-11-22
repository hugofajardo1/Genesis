package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Rubro;
import com.ar.genesis.sistema.core.exception.RubroExisteException;
import com.ar.genesis.sistema.core.input.IModificarRubroInput;
import com.ar.genesis.sistema.core.repository.IRubroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ModificarRubroUseCase implements IModificarRubroInput {

    IRubroRepository iRubroRepository;

    public ModificarRubroUseCase(IRubroRepository iRubroRepository) {
        this.iRubroRepository = iRubroRepository;
    }

    @Override
    public boolean modificarRubro(Rubro unRubro) throws RubroExisteException {
        if(iRubroRepository.existeRubro(unRubro.getNombre())){
            throw new RubroExisteException();
        }
        return iRubroRepository.guardarRubro(unRubro);
    }
}
