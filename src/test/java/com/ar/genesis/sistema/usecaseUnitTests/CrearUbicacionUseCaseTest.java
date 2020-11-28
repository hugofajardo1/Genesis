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
        Ubicacion ubicacion = Ubicacion.instancia(1, "Ubicacion 1");
        when(iUbicacionRepository.existeUbicacion("Ubicacion 1")).thenReturn(false);
        when(iUbicacionRepository.guardarUbicacion(ubicacion)).thenReturn(true);
        CrearUbicacionUseCase crearUbicacionUseCase = new CrearUbicacionUseCase(iUbicacionRepository);
        boolean resultado = crearUbicacionUseCase.crearUbicacion(ubicacion);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearTipoUbicacion_UbicacionExiste_NoGuardaTipoUbicacion() {
        Ubicacion ubicacion = Ubicacion.instancia(1, "Ubicacion 1");
        when(iUbicacionRepository.existeUbicacion("Ubicacion 1")).thenReturn(true);
        when(iUbicacionRepository.guardarUbicacion(ubicacion)).thenReturn(false);
        CrearUbicacionUseCase crearUbicacionUseCase = new CrearUbicacionUseCase(iUbicacionRepository);
        Assertions.assertThrows(UbicacionExisteException.class, () -> crearUbicacionUseCase.crearUbicacion(ubicacion));
    }
}
