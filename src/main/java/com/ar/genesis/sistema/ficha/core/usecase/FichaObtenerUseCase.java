package com.ar.genesis.sistema.ficha.core.usecase;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import com.ar.genesis.sistema.ficha.core.input.IFichaObtenerInput;
import com.ar.genesis.sistema.ficha.core.repository.IFichaObtenerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FichaObtenerUseCase implements IFichaObtenerInput {

    IFichaObtenerRepository miFichaObtenerRepository;

    public FichaObtenerUseCase(IFichaObtenerRepository miFichaObtenerRepository) { this.miFichaObtenerRepository = miFichaObtenerRepository; }

    @Override
    public List<Ficha> obtenerFichas() {
        return miFichaObtenerRepository.obtenerFichas();
    }
}
