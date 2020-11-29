package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Localidad;
import com.ar.genesis.sistema.core.exception.LocalidadExisteException;
import com.ar.genesis.sistema.core.repository.ILocalidadRepository;
import com.ar.genesis.sistema.core.usecase.CrearLocalidadUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class CrearLocalidadUseCaseTest {
    @Mock
    ILocalidadRepository iLocalidadRepository;
    @Test
    void crearLocalidad_LocalidadNoExiste_GuardaCorrectamente() throws LocalidadExisteException {
        Localidad unaLocalidad = Localidad.instancia(1, "Localidad 1");
        when(iLocalidadRepository.existeLocalidad("Localidad 1")).thenReturn(false);
        when(iLocalidadRepository.guardarLocalidad(unaLocalidad)).thenReturn(true);
        CrearLocalidadUseCase crearLocalidadUseCase = new CrearLocalidadUseCase(iLocalidadRepository);
        boolean resultado = crearLocalidadUseCase.crearLocalidad(unaLocalidad);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearLocalidad_LocalidadExiste_NoGuardaLocalidad() {
        Localidad unaLocalidad = Localidad.instancia(1, "Localidad 1");
        when(iLocalidadRepository.existeLocalidad("Localidad 1")).thenReturn(true);
        when(iLocalidadRepository.guardarLocalidad(unaLocalidad)).thenReturn(false);
        CrearLocalidadUseCase crearLocalidadUseCase = new CrearLocalidadUseCase(iLocalidadRepository);
        Assertions.assertThrows(LocalidadExisteException.class, () -> crearLocalidadUseCase.crearLocalidad(unaLocalidad));
    }
}