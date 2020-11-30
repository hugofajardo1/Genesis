package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Provincia;
import com.ar.genesis.sistema.core.input.IObtenerProvinciasInput;
import com.ar.genesis.sistema.core.repository.IProvinciaObtenerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProvinciaObtenerUseCase implements IObtenerProvinciasInput {

    IProvinciaObtenerRepository miProvinciaObtenerRepository;

    public ProvinciaObtenerUseCase(IProvinciaObtenerRepository miProvinciaObtenerRepository) { this.miProvinciaObtenerRepository = miProvinciaObtenerRepository; }

    @Override
    public List<Provincia> obtenerProvincias() {
        return miProvinciaObtenerRepository.obtenerProvincias();
    }
}
