package com.ar.genesis.sistema.localidad.usecase;

import com.ar.genesis.sistema.localidad.core.domain.Localidad;
import com.ar.genesis.sistema.localidad.core.exception.LocalidadExisteException;
import com.ar.genesis.sistema.localidad.core.repository.ILocalidadRepository;
import com.ar.genesis.sistema.localidad.core.usecase.LocalidadModificarUseCase;
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
        LocalidadModificarUseCase localidadModificarUseCase = new LocalidadModificarUseCase(miLocalidadRepository);
        boolean resultado = localidadModificarUseCase.modificarLocalidad(unaLocalidad);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarLocalidad_HayConflictoLocalidadExiste_LocalidadNoActualiza() {
        Localidad unaLocalidad = Localidad.instancia(1, "Localidad");
        when(miLocalidadRepository.existeLocalidad("Localidad")).thenReturn(true);
        when(miLocalidadRepository.guardarLocalidad(unaLocalidad)).thenReturn(false);
        LocalidadModificarUseCase localidadModificarUseCase = new LocalidadModificarUseCase(miLocalidadRepository);
        Assertions.assertThrows(LocalidadExisteException.class, () -> localidadModificarUseCase.modificarLocalidad(unaLocalidad));
    }
}
