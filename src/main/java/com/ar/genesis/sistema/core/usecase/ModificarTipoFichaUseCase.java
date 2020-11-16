package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.core.exception.TipoFichaExisteException;
import com.ar.genesis.sistema.core.input.IModificarTipoFichaInput;
import com.ar.genesis.sistema.core.repository.ITipoFichaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ModificarTipoFichaUseCase implements IModificarTipoFichaInput {

    ITipoFichaRepository iTipoFichaRepository;

    public ModificarTipoFichaUseCase(ITipoFichaRepository iTipoFichaRepository) {
        this.iTipoFichaRepository = iTipoFichaRepository;
    }

    @Override
    public boolean modificarTipoFicha(TipoFicha unTipoFicha) throws TipoFichaExisteException {
        if(iTipoFichaRepository.existeTipoFicha(unTipoFicha.getNombre())){
            throw new TipoFichaExisteException();
        }
        return iTipoFichaRepository.guardarTipoFicha(unTipoFicha);
    }
}
