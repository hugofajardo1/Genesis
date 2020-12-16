package com.ar.genesis.sistema.rubro.core.usecase;

import com.ar.genesis.sistema.rubro.core.domain.Rubro;
import com.ar.genesis.sistema.rubro.core.input.IRubroObtenerInput;
import com.ar.genesis.sistema.rubro.core.repository.IRubroObtenerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RubroObtenerUseCase implements IRubroObtenerInput {

    IRubroObtenerRepository miRubroObtenerRepository;

    public RubroObtenerUseCase(IRubroObtenerRepository miRubroObtenerRepository) { this.miRubroObtenerRepository = miRubroObtenerRepository; }

    @Override
    public List<Rubro> obtenerRubros() {
        return miRubroObtenerRepository.obtenerRubros();
    }
}
