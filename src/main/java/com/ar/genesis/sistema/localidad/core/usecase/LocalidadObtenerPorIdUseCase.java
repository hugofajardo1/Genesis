package com.ar.genesis.sistema.localidad.core.usecase;

import com.ar.genesis.sistema.localidad.core.domain.Localidad;
import com.ar.genesis.sistema.localidad.core.exception.LocalidadNoExisteException;
import com.ar.genesis.sistema.localidad.core.input.ILocalidadObtenerPorIdInput;
import com.ar.genesis.sistema.localidad.core.repository.ILocalidadObtenerPorIdRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LocalidadObtenerPorIdUseCase implements ILocalidadObtenerPorIdInput {

    ILocalidadObtenerPorIdRepository miLocalidadObtenerPorIdRepository;

    public LocalidadObtenerPorIdUseCase(ILocalidadObtenerPorIdRepository miLocalidadObtenerPorIdRepository) { this.miLocalidadObtenerPorIdRepository = miLocalidadObtenerPorIdRepository; }

    @Override
    public Localidad obtenerLocalidad(Integer id) throws LocalidadNoExisteException {
        Localidad unaLocalidad = miLocalidadObtenerPorIdRepository.obtenerLocalidad(id);
        if(unaLocalidad==null){
            throw new LocalidadNoExisteException();
        }
        return unaLocalidad;
    }
}
