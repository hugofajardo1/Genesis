package com.ar.genesis.sistema.subrubro.core.usecase;

import com.ar.genesis.sistema.subrubro.core.domain.SubRubro;
import com.ar.genesis.sistema.subrubro.core.input.ISubRubroObtenerInput;
import com.ar.genesis.sistema.subrubro.core.repository.ISubRubroObtenerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SubRubroObtenerUseCase implements ISubRubroObtenerInput {

    ISubRubroObtenerRepository miSubRubroObtenerRepository;

    public SubRubroObtenerUseCase(ISubRubroObtenerRepository miSubRubroObtenerRepository) { this.miSubRubroObtenerRepository = miSubRubroObtenerRepository; }

    @Override
    public List<SubRubro> obtenerSubRubros() {
        return miSubRubroObtenerRepository.obtenerSubRubros();
    }
}
