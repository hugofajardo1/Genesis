package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Rubro;
import com.ar.genesis.sistema.core.input.IRubroObtenerInput;
import com.ar.genesis.sistema.core.repository.IRubroObtenerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RubroRubroObtenerUseCase implements IRubroObtenerInput {

    IRubroObtenerRepository miRubroObtenerRepository;

    public RubroRubroObtenerUseCase(IRubroObtenerRepository miRubroObtenerRepository) { this.miRubroObtenerRepository = miRubroObtenerRepository; }

    @Override
    public List<Rubro> obtenerRubros() {
        return miRubroObtenerRepository.obtenerRubros();
    }
}
