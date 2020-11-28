package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Localidad;
import com.ar.genesis.sistema.core.exception.LocalidadExisteException;
import com.ar.genesis.sistema.core.repository.ILocalidadRepository;
import com.ar.genesis.sistema.core.usecase.ModificarLocalidadUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class ModificarLocalidadUseCaseTest {
    @Mock
    ILocalidadRepository iLocalidadRepository;
    @Test
    void modificarLocalidad_LocalidadActualizadoCorrectamente() throws LocalidadExisteException {
        Localidad unaLocalidad = Localidad.instancia(1, "Localidad");
        when(iLocalidadRepository.existeLocalidad("Localidad")).thenReturn(false);
        when(iLocalidadRepository.guardarLocalidad(unaLocalidad)).thenReturn(true);
        ModificarLocalidadUseCase modificarLocalidadUseCase = new ModificarLocalidadUseCase(iLocalidadRepository);
        boolean resultado = modificarLocalidadUseCase.modificarLocalidad(unaLocalidad);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarLocalidad_HayConflictoLocalidadExiste_LocalidadNoActualiza() {
        Localidad unaLocalidad = Localidad.instancia(1, "Localidad");
        when(iLocalidadRepository.existeLocalidad("Localidad")).thenReturn(true);
        when(iLocalidadRepository.guardarLocalidad(unaLocalidad)).thenReturn(false);
        ModificarLocalidadUseCase modificarLocalidadUseCase = new ModificarLocalidadUseCase(iLocalidadRepository);
        Assertions.assertThrows(LocalidadExisteException.class, () -> modificarLocalidadUseCase.modificarLocalidad(unaLocalidad));
    }
}
