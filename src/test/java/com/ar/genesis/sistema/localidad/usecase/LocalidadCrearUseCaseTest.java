package com.ar.genesis.sistema.localidad.usecase;

import com.ar.genesis.sistema.localidad.core.domain.Localidad;
import com.ar.genesis.sistema.localidad.core.exception.LocalidadExisteException;
import com.ar.genesis.sistema.localidad.core.repository.ILocalidadRepository;
import com.ar.genesis.sistema.localidad.core.usecase.LocalidadCrearUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class LocalidadCrearUseCaseTest {
    @Mock
    ILocalidadRepository miLocalidadRepository;
    @Test
    void crearLocalidad_LocalidadNoExiste_GuardaCorrectamente() throws LocalidadExisteException {
        Localidad unaLocalidad = Localidad.instancia(1, "Localidad 1");
        when(miLocalidadRepository.existeLocalidad("Localidad 1")).thenReturn(false);
        when(miLocalidadRepository.guardarLocalidad(unaLocalidad)).thenReturn(true);
        LocalidadCrearUseCase localidadCrearUseCase = new LocalidadCrearUseCase(miLocalidadRepository);
        boolean resultado = localidadCrearUseCase.crearLocalidad(unaLocalidad);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearLocalidad_LocalidadExiste_NoGuardaLocalidad() {
        Localidad unaLocalidad = Localidad.instancia(1, "Localidad 1");
        when(miLocalidadRepository.existeLocalidad("Localidad 1")).thenReturn(true);
        when(miLocalidadRepository.guardarLocalidad(unaLocalidad)).thenReturn(false);
        LocalidadCrearUseCase localidadCrearUseCase = new LocalidadCrearUseCase(miLocalidadRepository);
        Assertions.assertThrows(LocalidadExisteException.class, () -> localidadCrearUseCase.crearLocalidad(unaLocalidad));
    }
}
