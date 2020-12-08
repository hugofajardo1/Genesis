package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Rubro;
import com.ar.genesis.sistema.core.exception.RubroNoExisteException;
import com.ar.genesis.sistema.core.input.IRubroObtenerPorIdInput;
import com.ar.genesis.sistema.core.repository.IRubroObtenerPorIdRepository;
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
