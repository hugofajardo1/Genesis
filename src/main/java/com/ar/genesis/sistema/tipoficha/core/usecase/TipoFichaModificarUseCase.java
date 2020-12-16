package com.ar.genesis.sistema.tipoficha.core.usecase;

import com.ar.genesis.sistema.tipoficha.core.domain.TipoFicha;
import com.ar.genesis.sistema.tipoficha.core.exception.TipoFichaExisteException;
import com.ar.genesis.sistema.tipoficha.core.input.ITipoFichaModificarInput;
import com.ar.genesis.sistema.tipoficha.core.repository.ITipoFichaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoFichaModificarUseCase implements ITipoFichaModificarInput {

    ITipoFichaRepository miTipoFichaRepository;

    public TipoFichaModificarUseCase(ITipoFichaRepository miTipoFichaRepository) { this.miTipoFichaRepository = miTipoFichaRepository; }

    @Override
    public boolean modificarTipoFicha(TipoFicha unTipoFicha) throws TipoFichaExisteException {
        if(miTipoFichaRepository.existeTipoFicha(unTipoFicha.getNombre())){
            throw new TipoFichaExisteException();
        }
        return miTipoFichaRepository.guardarTipoFicha(unTipoFicha);
    }
}
