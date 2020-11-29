package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Ficha;
import com.ar.genesis.sistema.core.exception.FichaExisteException;
import com.ar.genesis.sistema.core.input.ICrearFichaInput;
import com.ar.genesis.sistema.core.repository.IFichaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FichaCrearUseCase implements ICrearFichaInput {

    IFichaRepository miFichaRepository;

    public FichaCrearUseCase(IFichaRepository miFichaRepository) {
        this.miFichaRepository = miFichaRepository;
    }

    @Override
    public boolean crearFicha(Ficha unaFicha) throws FichaExisteException {
        if(miFichaRepository.existeFicha(unaFicha.getNombre())){
            throw new FichaExisteException();
        }
        return miFichaRepository.guardarFicha(unaFicha);
    }
}