package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Ubicacion;
import com.ar.genesis.sistema.core.exception.UbicacionExisteException;
import com.ar.genesis.sistema.core.repository.IUbicacionRepository;
import com.ar.genesis.sistema.core.usecase.UbicacionUseCaseCrear;
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
    void crearTipoUbicacion_UbicacionNoExiste_GuardaCorrectamente() throws UbicacionExisteException {
        Ubicacion ubicacion = Ubicacion.instancia(1, "Ubicacion 1");
        when(miUbicacionRepository.existeUbicacion("Ubicacion 1")).thenReturn(false);
        when(miUbicacionRepository.guardarUbicacion(ubicacion)).thenReturn(true);
        UbicacionUseCaseCrear ubicacionCrearUseCase = new UbicacionUseCaseCrear(miUbicacionRepository);
        boolean resultado = ubicacionCrearUseCase.crearUbicacion(ubicacion);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearTipoUbicacion_UbicacionExiste_NoGuardaTipoUbicacion() {
        Ubicacion ubicacion = Ubicacion.instancia(1, "Ubicacion 1");
        when(miUbicacionRepository.existeUbicacion("Ubicacion 1")).thenReturn(true);
        when(miUbicacionRepository.guardarUbicacion(ubicacion)).thenReturn(false);
        UbicacionUseCaseCrear ubicacionCrearUseCase = new UbicacionUseCaseCrear(miUbicacionRepository);
        Assertions.assertThrows(UbicacionExisteException.class, () -> ubicacionCrearUseCase.crearUbicacion(ubicacion));
    }
}
