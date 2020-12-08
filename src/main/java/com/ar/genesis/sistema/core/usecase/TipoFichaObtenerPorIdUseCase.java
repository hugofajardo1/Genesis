package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.core.exception.TipoFichaNoExisteException;
import com.ar.genesis.sistema.core.input.ITipoFichaObtenerPorIdInput;
import com.ar.genesis.sistema.core.repository.ITipoFichaObtenerPorIdRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoFichaObtenerPorIdUseCase implements ITipoFichaObtenerPorIdInput {

    ITipoFichaObtenerPorIdRepository miTipoFichaObtenerPorIdRepository;

    public TipoFichaObtenerPorIdUseCase(ITipoFichaObtenerPorIdRepository miTipoFichaObtenerPorIdRepository) { this.miTipoFichaObtenerPorIdRepository = miTipoFichaObtenerPorIdRepository; }

    @Override
    public TipoFicha obtenerTipoFicha(Integer id) throws TipoFichaNoExisteException {
        TipoFicha unTipoFicha = miTipoFichaObtenerPorIdRepository.obtenerTipoFicha(id);
        if(unTipoFicha==null){
            throw new TipoFichaNoExisteException();
        }
        return unTipoFicha;
    }
}
