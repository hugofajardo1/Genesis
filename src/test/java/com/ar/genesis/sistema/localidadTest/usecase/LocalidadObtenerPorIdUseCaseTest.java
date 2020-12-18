package com.ar.genesis.sistema.localidadTest.usecase;

import com.ar.genesis.sistema.localidad.core.domain.Localidad;
import com.ar.genesis.sistema.localidad.core.exception.LocalidadNoExisteException;
import com.ar.genesis.sistema.localidad.core.repository.ILocalidadObtenerPorIdRepository;
import com.ar.genesis.sistema.localidad.core.usecase.LocalidadObtenerPorIdUseCase;
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
    public void obtenerLocalidadPorId_devuelveLocalidadNoExiste() {

        when(miLocalidadObtenerPorIdRepository.obtenerLocalidad(1)).thenReturn(null);

        LocalidadObtenerPorIdUseCase localidadObtenerPorIdUseCase = new LocalidadObtenerPorIdUseCase(miLocalidadObtenerPorIdRepository);
        Assertions.assertThrows(LocalidadNoExisteException.class, () -> localidadObtenerPorIdUseCase.obtenerLocalidad(1));
    }
}