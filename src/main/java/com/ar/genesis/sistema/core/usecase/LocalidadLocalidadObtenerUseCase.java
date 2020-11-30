package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Localidad;
import com.ar.genesis.sistema.core.input.ILocalidadObtenerInput;
import com.ar.genesis.sistema.core.repository.ILocalidadObtenerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LocalidadLocalidadObtenerUseCase implements ILocalidadObtenerInput {

    ILocalidadObtenerRepository miLocalidadObtenerRepository;

    public LocalidadLocalidadObtenerUseCase(ILocalidadObtenerRepository miLocalidadObtenerRepository) { this.miLocalidadObtenerRepository = miLocalidadObtenerRepository; }

    @Override
    public List<Localidad> obtenerLocalidades() {
        return miLocalidadObtenerRepository.obtenerLocalidades();
    }
}
