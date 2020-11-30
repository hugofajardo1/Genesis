package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Localidad;
import com.ar.genesis.sistema.core.exception.LocalidadExisteException;
import com.ar.genesis.sistema.core.repository.ILocalidadRepository;
import com.ar.genesis.sistema.core.usecase.LocalidadUseCaseModificar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class LocalidadModificarUseCaseTest {
    @Mock
    ILocalidadRepository miLocalidadRepository;
    @Test
    void modificarLocalidad_LocalidadActualizadoCorrectamente() throws LocalidadExisteException {
        Localidad unaLocalidad = Localidad.instancia(1, "Localidad");
        when(miLocalidadRepository.existeLocalidad("Localidad")).thenReturn(false);
        when(miLocalidadRepository.guardarLocalidad(unaLocalidad)).thenReturn(true);
        LocalidadUseCaseModificar localidadModificarUseCase = new LocalidadUseCaseModificar(miLocalidadRepository);
        boolean resultado = localidadModificarUseCase.modificarLocalidad(unaLocalidad);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarLocalidad_HayConflictoLocalidadExiste_LocalidadNoActualiza() {
        Localidad unaLocalidad = Localidad.instancia(1, "Localidad");
        when(miLocalidadRepository.existeLocalidad("Localidad")).thenReturn(true);
        when(miLocalidadRepository.guardarLocalidad(unaLocalidad)).thenReturn(false);
        LocalidadUseCaseModificar localidadModificarUseCase = new LocalidadUseCaseModificar(miLocalidadRepository);
        Assertions.assertThrows(LocalidadExisteException.class, () -> localidadModificarUseCase.modificarLocalidad(unaLocalidad));
    }
}
