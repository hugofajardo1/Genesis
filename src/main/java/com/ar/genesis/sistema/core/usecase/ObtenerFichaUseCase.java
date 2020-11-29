package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Ficha;
import com.ar.genesis.sistema.core.input.IObtenerFichaInput;
import com.ar.genesis.sistema.core.repository.IObtenerFichasRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ObtenerFichaUseCase implements IObtenerFichaInput {

    IObtenerFichasRepository miObtenerFichasRepository;

    public ObtenerFichaUseCase(IObtenerFichasRepository miObtenerFichasRepository) { this.miObtenerFichasRepository = miObtenerFichasRepository; }

    @Override
    public List<Ficha> obtenerFichas() {
        return miObtenerFichasRepository.obtenerFichas();
    }
}
