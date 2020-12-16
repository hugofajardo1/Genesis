package com.ar.genesis.sistema.rubro.core.usecase;

import com.ar.genesis.sistema.rubro.core.domain.Rubro;
import com.ar.genesis.sistema.rubro.core.exception.RubroNoExisteException;
import com.ar.genesis.sistema.rubro.core.input.IRubroObtenerPorIdInput;
import com.ar.genesis.sistema.rubro.core.repository.IRubroObtenerPorIdRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RubroObtenerPorIdUseCase implements IRubroObtenerPorIdInput {

    IRubroObtenerPorIdRepository miRubroObtenerPorIdRepository;

    public RubroObtenerPorIdUseCase(IRubroObtenerPorIdRepository miRubroObtenerPorIdRepository) { this.miRubroObtenerPorIdRepository = miRubroObtenerPorIdRepository; }

    @Override
    public Rubro obtenerRubro(Integer id) throws RubroNoExisteException {
        Rubro unRubro = miRubroObtenerPorIdRepository.obtenerRubro(id);
        if(unRubro==null){
            throw new RubroNoExisteException();
        }
        return unRubro;
    }
}
