package com.ar.genesis.sistema.ficha.core.usecase;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import com.ar.genesis.sistema.ficha.core.exception.FichaExisteException;
import com.ar.genesis.sistema.ficha.core.input.IFichaCrearInput;
import com.ar.genesis.sistema.ficha.core.repository.IFichaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FichaCrearUseCase implements IFichaCrearInput {

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