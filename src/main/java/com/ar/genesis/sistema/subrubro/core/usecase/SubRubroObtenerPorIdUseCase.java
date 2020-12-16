package com.ar.genesis.sistema.subrubro.core.usecase;

import com.ar.genesis.sistema.subrubro.core.domain.SubRubro;
import com.ar.genesis.sistema.subrubro.core.exception.SubRubroNoExisteException;
import com.ar.genesis.sistema.subrubro.core.input.ISubRubroObtenerPorIdInput;
import com.ar.genesis.sistema.subrubro.core.repository.ISubRubroObtenerPorIdRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SubRubroObtenerPorIdUseCase implements ISubRubroObtenerPorIdInput {

    ISubRubroObtenerPorIdRepository miSubRubroObtenerPorIdRepository;

    public SubRubroObtenerPorIdUseCase(ISubRubroObtenerPorIdRepository miSubRubroObtenerPorIdRepository) { this.miSubRubroObtenerPorIdRepository = miSubRubroObtenerPorIdRepository; }

    @Override
    public SubRubro obtenerSubRubro(Integer id) throws SubRubroNoExisteException {
        SubRubro unSubRubro = miSubRubroObtenerPorIdRepository.obtenerSubRubro(id);
        if(unSubRubro==null){
            throw new SubRubroNoExisteException();
        }
        return unSubRubro;
    }
}
