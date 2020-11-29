package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Ficha;
import com.ar.genesis.sistema.core.exception.FichaExisteException;
import com.ar.genesis.sistema.core.input.IModificarFichaInput;
import com.ar.genesis.sistema.core.repository.IFichaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ModificarFichaUseCase implements IModificarFichaInput {

    IFichaRepository miFichaRepository;

    public ModificarFichaUseCase(IFichaRepository miFichaRepository) {
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
