package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Provincia;
import com.ar.genesis.sistema.core.input.IObtenerProvinciasInput;
import com.ar.genesis.sistema.core.repository.IObtenerProvinciasRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ObtenerProvinciasUseCase implements IObtenerProvinciasInput {

    IObtenerProvinciasRepository miObtenerProvinciasRepository;

    public ObtenerProvinciasUseCase(IObtenerProvinciasRepository miObtenerProvinciasRepository) { this.miObtenerProvinciasRepository = miObtenerProvinciasRepository; }

    @Override
    public List<Provincia> obtenerProvincias() {
        return miObtenerProvinciasRepository.obtenerProvincias();
    }
}
