package com.ar.genesis.sistema.ubicacion.usecase;

import com.ar.genesis.sistema.ubicacion.core.domain.Ubicacion;
import com.ar.genesis.sistema.ubicacion.core.exception.UbicacionExisteException;
import com.ar.genesis.sistema.ubicacion.core.repository.IUbicacionRepository;
import com.ar.genesis.sistema.ubicacion.core.usecase.UbicacionCrearUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class UbicacionCrearUseCaseTest {
    @Mock
    IUbicacionRepository miUbicacionRepository;
    @Test
    void crearUbicacion_UbicacionNoExiste_GuardaCorrectamente() throws UbicacionExisteException {
        Ubicacion unaUbicacion = Ubicacion.instancia(1, "Ubicacion 1");
        when(miUbicacionRepository.existeUbicacion("Ubicacion 1")).thenReturn(false);
        when(miUbicacionRepository.guardarUbicacion(unaUbicacion)).thenReturn(true);
        UbicacionCrearUseCase ubicacionCrearUseCase = new UbicacionCrearUseCase(miUbicacionRepository);
        boolean resultado = ubicacionCrearUseCase.crearUbicacion(unaUbicacion);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearUbicacion_UbicacionExiste_NoGuardaUbicacion() {
        Ubicacion unaUbicacion = Ubicacion.instancia(1, "Ubicacion 1");
        when(miUbicacionRepository.existeUbicacion("Ubicacion 1")).thenReturn(true);
        when(miUbicacionRepository.guardarUbicacion(unaUbicacion)).thenReturn(false);
        UbicacionCrearUseCase ubicacionCrearUseCase = new UbicacionCrearUseCase(miUbicacionRepository);
        Assertions.assertThrows(UbicacionExisteException.class, () -> ubicacionCrearUseCase.crearUbicacion(unaUbicacion));
    }
}
