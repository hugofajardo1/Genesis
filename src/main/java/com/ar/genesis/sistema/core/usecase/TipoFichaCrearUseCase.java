package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.core.exception.TipoFichaExisteException;
import com.ar.genesis.sistema.core.input.ICrearTipoFichaInput;
import com.ar.genesis.sistema.core.repository.ITipoFichaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoFichaCrearUseCase implements ICrearTipoFichaInput {

    ITipoFichaRepository miTipoFichaRepository;

    public TipoFichaCrearUseCase(ITipoFichaRepository miTipoFichaRepository) { this.miTipoFichaRepository = miTipoFichaRepository; }

    @Override
    public boolean crearTipoFicha(TipoFicha unTipoFicha) throws TipoFichaExisteException {
        if(miTipoFichaRepository.existeTipoFicha(unTipoFicha.getNombre())){
            throw new TipoFichaExisteException();
        }
        return miTipoFichaRepository.guardarTipoFicha(unTipoFicha);
    }
}
