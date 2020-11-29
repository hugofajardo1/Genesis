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

    ITipoFichaRepository miTipoFichaRepository;

    public ModificarTipoFichaUseCase(ITipoFichaRepository miTipoFichaRepository) { this.miTipoFichaRepository = miTipoFichaRepository; }

    @Override
    public boolean modificarTipoFicha(TipoFicha unTipoFicha) throws TipoFichaExisteException {
        if(miTipoFichaRepository.existeTipoFicha(unTipoFicha.getNombre())){
            throw new TipoFichaExisteException();
        }
        return miTipoFichaRepository.guardarTipoFicha(unTipoFicha);
    }
}
