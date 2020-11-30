package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Ubicacion;
import com.ar.genesis.sistema.core.exception.UbicacionExisteException;
import com.ar.genesis.sistema.core.repository.IUbicacionRepository;
import com.ar.genesis.sistema.core.usecase.UbicacionUseCaseModificar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class UbicacionModificarUseCaseTest {
    @Mock
    IUbicacionRepository miUbicacionRepository;
    @Test
    void modificarUbicacion_UbicacionActualizadoCorrectamente() throws UbicacionExisteException {
        Ubicacion unaUbicacion = Ubicacion.instancia(1, "Ubicacion");
        when(miUbicacionRepository.existeUbicacion("Ubicacion")).thenReturn(false);
        when(miUbicacionRepository.guardarUbicacion(unaUbicacion)).thenReturn(true);
        UbicacionUseCaseModificar ubicacionModificarUseCase = new UbicacionUseCaseModificar(miUbicacionRepository);
        boolean resultado = ubicacionModificarUseCase.modificarUbicacion(unaUbicacion);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarUbicacion_HayConflictoUbicacionExiste_UbicacionNoActualiza() {
        Ubicacion unaUbicacion = Ubicacion.instancia(1, "Ubicacion");
        when(miUbicacionRepository.existeUbicacion("Ubicacion")).thenReturn(true);
        when(miUbicacionRepository.guardarUbicacion(unaUbicacion)).thenReturn(false);
        UbicacionUseCaseModificar ubicacionModificarUseCase = new UbicacionUseCaseModificar(miUbicacionRepository);
        Assertions.assertThrows(UbicacionExisteException.class, () -> ubicacionModificarUseCase.modificarUbicacion(unaUbicacion));
    }
}
