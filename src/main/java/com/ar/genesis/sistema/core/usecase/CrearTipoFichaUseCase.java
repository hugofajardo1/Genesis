package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.core.exception.TipoFichaExisteException;
import com.ar.genesis.sistema.core.input.ICrearTipoFichaInput;
import com.ar.genesis.sistema.core.repository.ITipoFichaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CrearTipoFichaUseCase implements ICrearTipoFichaInput {

    ITipoFichaRepository iTipoFichaRepository;

    public CrearTipoFichaUseCase(ITipoFichaRepository iTipoFichaRepository) {
        this.iTipoFichaRepository = iTipoFichaRepository;
    }

    @Override
    public boolean crearTipoFicha(TipoFicha unTipoFicha) throws TipoFichaExisteException {
        if(iTipoFichaRepository.existeTipoCliente(unTipoFicha.getNombre())){
            throw new TipoFichaExisteException();
        }
        return iTipoFichaRepository.guardarTipoCliente(unTipoFicha);
    }
}
