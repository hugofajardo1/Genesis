package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.SubRubro;
import com.ar.genesis.sistema.core.input.IObtenerSubRubrosInput;
import com.ar.genesis.sistema.core.repository.IObtenerSubRubrosRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ObtenerSubRubrosUseCase implements IObtenerSubRubrosInput {

    IObtenerSubRubrosRepository miObtenerSubRubrosRepository;

    public ObtenerSubRubrosUseCase(IObtenerSubRubrosRepository miObtenerSubRubrosRepository) { this.miObtenerSubRubrosRepository = miObtenerSubRubrosRepository; }

    @Override
    public List<SubRubro> obtenerSubRubros() {
        return miObtenerSubRubrosRepository.obtenerSubRubros();
    }
}
