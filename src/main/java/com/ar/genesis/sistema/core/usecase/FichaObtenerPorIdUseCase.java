package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Ficha;
import com.ar.genesis.sistema.core.exception.FichaNoExisteException;
import com.ar.genesis.sistema.core.input.IFichaObtenerPorIdInput;
import com.ar.genesis.sistema.core.repository.IFichaObtenerPorIdRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FichaObtenerPorIdUseCase implements IFichaObtenerPorIdInput {

    IFichaObtenerPorIdRepository miFichaObtenerPorIdRepository;

    public FichaObtenerPorIdUseCase(IFichaObtenerPorIdRepository miFichaObtenerPorIdRepository) { this.miFichaObtenerPorIdRepository = miFichaObtenerPorIdRepository; }

    @Override
    public Ficha obtenerFicha(Integer id) throws FichaNoExisteException {
        Ficha unaFicha = miFichaObtenerPorIdRepository.obtenerFicha(id);
        if(unaFicha==null){
            throw new FichaNoExisteException();
        }
        return unaFicha;
    }
}
