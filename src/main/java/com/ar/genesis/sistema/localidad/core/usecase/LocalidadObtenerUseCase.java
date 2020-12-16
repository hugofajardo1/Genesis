package com.ar.genesis.sistema.localidad.core.usecase;

import com.ar.genesis.sistema.localidad.core.domain.Localidad;
import com.ar.genesis.sistema.localidad.core.input.ILocalidadObtenerInput;
import com.ar.genesis.sistema.localidad.core.repository.ILocalidadObtenerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LocalidadObtenerUseCase implements ILocalidadObtenerInput {

    ILocalidadObtenerRepository miLocalidadObtenerRepository;

    public LocalidadObtenerUseCase(ILocalidadObtenerRepository miLocalidadObtenerRepository) { this.miLocalidadObtenerRepository = miLocalidadObtenerRepository; }

    @Override
    public List<Localidad> obtenerLocalidades() {
        return miLocalidadObtenerRepository.obtenerLocalidades();
    }
}
