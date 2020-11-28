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
    void crearTipoLocalidad_LocalidadNoExiste_GuardaCorrectamente() throws LocalidadExisteException {
        Localidad LocalidadNueva = Localidad.instancia(1, "Localidad 1");
        when(iLocalidadRepository.existeLocalidad("Localidad 1")).thenReturn(false);
        when(iLocalidadRepository.guardarLocalidad(LocalidadNueva)).thenReturn(true);
        CrearLocalidadUseCase crearTipoLocalidadUseCase = new CrearLocalidadUseCase(iLocalidadRepository);
        boolean resultado = crearTipoLocalidadUseCase.crearLocalidad(LocalidadNueva);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearTipoLocalidad_LocalidadExiste_NoGuardaTipoLocalidad() {
        Localidad LocalidadNueva = Localidad.instancia(1, "Localidad 1");
        when(iLocalidadRepository.existeLocalidad("Localidad 1")).thenReturn(true);
        when(iLocalidadRepository.guardarLocalidad(LocalidadNueva)).thenReturn(false);
        CrearLocalidadUseCase crearTipoLocalidadUseCase = new CrearLocalidadUseCase(iLocalidadRepository);
        Assertions.assertThrows(LocalidadExisteException.class, () -> crearTipoLocalidadUseCase.crearLocalidad(LocalidadNueva));
    }
}
