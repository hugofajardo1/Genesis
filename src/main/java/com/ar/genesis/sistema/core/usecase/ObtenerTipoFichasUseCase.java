package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.core.input.IObtenerTipoFichasInput;
import com.ar.genesis.sistema.core.repository.IObtenerTipoFichasRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ObtenerTipoFichasUseCase implements IObtenerTipoFichasInput {

    IObtenerTipoFichasRepository iObtenerTipoFichasRepository;

    public ObtenerTipoFichasUseCase(IObtenerTipoFichasRepository iObtenerTipoFichasRepository) {
        this.iObtenerTipoFichasRepository = iObtenerTipoFichasRepository;
    }

    @Override
    public List<TipoFicha> obtenerTipoFichas() {
        return iObtenerTipoFichasRepository.obtenerTipoFichas();
    }
}
