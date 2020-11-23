package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Ubicacion;
import com.ar.genesis.sistema.core.exception.UbicacionExisteException;
import com.ar.genesis.sistema.core.repository.IUbicacionRepository;
import com.ar.genesis.sistema.core.usecase.CrearUbicacionUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class CrearUbicacionUseCaseTest {
    @Mock
    IUbicacionRepository iUbicacionRepository;
    @Test
    void crearTipoUbicacion_UbicacionNoExiste_GuardaCorrectamente() throws UbicacionExisteException {
        Ubicacion UbicacionNueva = Ubicacion.instancia(1, "Ubicacion 1");
        when(iUbicacionRepository.existeUbicacion("Ubicacion 1")).thenReturn(false);
        when(iUbicacionRepository.guardarUbicacion(UbicacionNueva)).thenReturn(true);
        CrearUbicacionUseCase crearTipoUbicacionUseCase = new CrearUbicacionUseCase(iUbicacionRepository);
        boolean resultado = crearTipoUbicacionUseCase.crearUbicacion(UbicacionNueva);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearTipoUbicacion_UbicacionExiste_NoGuardaTipoUbicacion() {
        Ubicacion UbicacionNueva = Ubicacion.instancia(1, "Ubicacion 1");
        when(iUbicacionRepository.existeUbicacion("Ubicacion 1")).thenReturn(true);
        when(iUbicacionRepository.guardarUbicacion(UbicacionNueva)).thenReturn(false);
        CrearUbicacionUseCase crearTipoUbicacionUseCase = new CrearUbicacionUseCase(iUbicacionRepository);
        Assertions.assertThrows(UbicacionExisteException.class, () -> crearTipoUbicacionUseCase.crearUbicacion(UbicacionNueva));
    }
}
