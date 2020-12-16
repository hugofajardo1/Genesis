package com.ar.genesis.sistema.ubicacion.core.usecase;

import com.ar.genesis.sistema.ubicacion.core.domain.Ubicacion;
import com.ar.genesis.sistema.ubicacion.core.exception.UbicacionNoExisteException;
import com.ar.genesis.sistema.ubicacion.core.input.IUbicacionObtenerPorIdInput;
import com.ar.genesis.sistema.ubicacion.core.repository.IUbicacionObtenerPorIdRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UbicacionObtenerPorIdUseCase implements IUbicacionObtenerPorIdInput {

    IUbicacionObtenerPorIdRepository miUbicacionObtenerPorIdRepository;

    public UbicacionObtenerPorIdUseCase(IUbicacionObtenerPorIdRepository miUbicacionObtenerPorIdRepository) { this.miUbicacionObtenerPorIdRepository = miUbicacionObtenerPorIdRepository; }

    @Override
    public Ubicacion obtenerUbicacion(Integer id) throws UbicacionNoExisteException {
        Ubicacion unaUbicacion = miUbicacionObtenerPorIdRepository.obtenerUbicacion(id);
        if(unaUbicacion==null){
            throw new UbicacionNoExisteException();
        }
        return unaUbicacion;
    }
}
