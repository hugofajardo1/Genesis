package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Localidad;
import com.ar.genesis.sistema.core.input.IObtenerLocalidadesInput;
import com.ar.genesis.sistema.core.repository.IObtenerLocalidadesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ObtenerLocalidadesUseCase implements IObtenerLocalidadesInput {

    IObtenerLocalidadesRepository miObtenerLocalidadesRepository;

    public ObtenerLocalidadesUseCase(IObtenerLocalidadesRepository miObtenerLocalidadesRepository) { this.miObtenerLocalidadesRepository = miObtenerLocalidadesRepository; }

    @Override
    public List<Localidad> obtenerLocalidades() {
        return miObtenerLocalidadesRepository.obtenerLocalidades();
    }
}
