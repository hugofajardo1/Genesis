package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Localidad;
import com.ar.genesis.sistema.core.exception.LocalidadNoExisteException;
import com.ar.genesis.sistema.core.repository.ILocalidadObtenerPorIdRepository;
import com.ar.genesis.sistema.core.usecase.LocalidadObtenerPorIdUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class LocalidadObtenerPorIdUseCaseTest {
    @Mock
    ILocalidadObtenerPorIdRepository miLocalidadObtenerPorIdRepository;

    @Test
    public void obtenerLocalidadPorId_devuelveLocalidad() throws LocalidadNoExisteException {
        Localidad unaLocalidad = Localidad.instancia(1, "Localidad 1");

        when(miLocalidadObtenerPorIdRepository.obtenerLocalidad(1)).thenReturn(unaLocalidad);

        LocalidadObtenerPorIdUseCase localidadObtenerPorIdUseCase = new LocalidadObtenerPorIdUseCase(miLocalidadObtenerPorIdRepository);
        Localidad resultado = localidadObtenerPorIdUseCase.obtenerLocalidad(1);
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerLocalidadPorId_devuelveLocalidadNoExiste() throws LocalidadNoExisteException {

        when(miLocalidadObtenerPorIdRepository.obtenerLocalidad(1)).thenReturn(null);

        LocalidadObtenerPorIdUseCase localidadObtenerPorIdUseCase = new LocalidadObtenerPorIdUseCase(miLocalidadObtenerPorIdRepository);
        Assertions.assertThrows(LocalidadNoExisteException.class, () -> localidadObtenerPorIdUseCase.obtenerLocalidad(1));
    }
}