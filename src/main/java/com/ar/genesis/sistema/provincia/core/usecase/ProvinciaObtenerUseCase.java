package com.ar.genesis.sistema.provincia.core.usecase;

import com.ar.genesis.sistema.provincia.core.domain.Provincia;
import com.ar.genesis.sistema.provincia.core.input.IProvinciaObtenerInput;
import com.ar.genesis.sistema.provincia.core.repository.IProvinciaObtenerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProvinciaObtenerUseCase implements IProvinciaObtenerInput {

    IProvinciaObtenerRepository miProvinciaObtenerRepository;

    public ProvinciaObtenerUseCase(IProvinciaObtenerRepository miProvinciaObtenerRepository) { this.miProvinciaObtenerRepository = miProvinciaObtenerRepository; }

    @Override
    public List<Provincia> obtenerProvincias() {
        return miProvinciaObtenerRepository.obtenerProvincias();
    }
}
