package com.ar.genesis.sistema.ficha.core.usecase;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import com.ar.genesis.sistema.ficha.core.exception.FichaExisteException;
import com.ar.genesis.sistema.ficha.core.input.IFichaModificarInput;
import com.ar.genesis.sistema.ficha.core.repository.IFichaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FichaModificarUseCase implements IFichaModificarInput {

    IFichaRepository miFichaRepository;

    public FichaModificarUseCase(IFichaRepository miFichaRepository) {
        this.miFichaRepository = miFichaRepository;
    }

    @Override
    public boolean modificarFicha(Ficha unaFicha) throws FichaExisteException {
        if (miFichaRepository.existeFicha(unaFicha.getNombre())){
            throw new FichaExisteException();
        }
        return miFichaRepository.guardarFicha(unaFicha);
    }
}
