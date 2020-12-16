package com.ar.genesis.sistema.provincia.core.usecase;

import com.ar.genesis.sistema.provincia.core.domain.Provincia;
import com.ar.genesis.sistema.provincia.core.exception.ProvinciaNoExisteException;
import com.ar.genesis.sistema.provincia.core.input.IProvinciaObtenerPorIdInput;
import com.ar.genesis.sistema.provincia.core.repository.IProvinciaObtenerPorIdRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProvinciaObtenerPorIdUseCase implements IProvinciaObtenerPorIdInput {

    IProvinciaObtenerPorIdRepository miProvinciaObtenerPorIdRepository;

    public ProvinciaObtenerPorIdUseCase(IProvinciaObtenerPorIdRepository miProvinciaObtenerPorIdRepository) { this.miProvinciaObtenerPorIdRepository = miProvinciaObtenerPorIdRepository; }

    @Override
    public Provincia obtenerProvincia(Integer id) throws ProvinciaNoExisteException {
        Provincia unaProvincia = miProvinciaObtenerPorIdRepository.obtenerProvincia(id);
        if(unaProvincia==null){
            throw new ProvinciaNoExisteException();
        }
        return unaProvincia;
    }
}
