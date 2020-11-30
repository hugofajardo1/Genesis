package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.SubRubro;
import com.ar.genesis.sistema.core.input.IObtenerSubRubrosInput;
import com.ar.genesis.sistema.core.repository.ISubRubroObtenerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SubRubroObtenerUseCase implements IObtenerSubRubrosInput {

    ISubRubroObtenerRepository miSubRubroObtenerRepository;

    public SubRubroObtenerUseCase(ISubRubroObtenerRepository miSubRubroObtenerRepository) { this.miSubRubroObtenerRepository = miSubRubroObtenerRepository; }

    @Override
    public List<SubRubro> obtenerSubRubros() {
        return miSubRubroObtenerRepository.obtenerSubRubros();
    }
}
