package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Ficha;
import com.ar.genesis.sistema.core.exception.FichaExisteException;
import com.ar.genesis.sistema.core.input.ICrearFichaInput;
import com.ar.genesis.sistema.core.repository.IFichaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CrearFichaUseCase implements ICrearFichaInput {

    IFichaRepository iFichaRepository;

    public CrearFichaUseCase(IFichaRepository iFichaRepository) {
        this.iFichaRepository = iFichaRepository;
    }

    @Override
    public boolean crearFicha(Ficha ficha) throws FichaExisteException {
        if(iFichaRepository.existeFicha(ficha.getNombre())){
            throw new FichaExisteException();
        }
        return iFichaRepository.guardarFicha(ficha);
    }
}