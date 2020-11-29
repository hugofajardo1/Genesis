package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Rubro;
import com.ar.genesis.sistema.core.input.IObtenerRubrosInput;
import com.ar.genesis.sistema.core.repository.IObtenerRubrosRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ObtenerRubrosUseCase implements IObtenerRubrosInput {

    IObtenerRubrosRepository miObtenerRubrosRepository;

    public ObtenerRubrosUseCase(IObtenerRubrosRepository miObtenerRubrosRepository) { this.miObtenerRubrosRepository = miObtenerRubrosRepository; }

    @Override
    public List<Rubro> obtenerRubros() {
        return miObtenerRubrosRepository.obtenerRubros();
    }
}
