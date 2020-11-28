package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Ubicacion;
import com.ar.genesis.sistema.core.exception.UbicacionExisteException;
import com.ar.genesis.sistema.core.repository.IUbicacionRepository;
import com.ar.genesis.sistema.core.usecase.ModificarUbicacionUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class ModificarUbicacionUseCaseTest {
    @Mock
    IUbicacionRepository iUbicacionRepository;
    @Test
    void modificarUbicacion_UbicacionActualizadoCorrectamente() throws UbicacionExisteException {
        Ubicacion unaUbicacion = Ubicacion.instancia(1, "Ubicacion");
        when(iUbicacionRepository.existeUbicacion("Ubicacion")).thenReturn(false);
        when(iUbicacionRepository.guardarUbicacion(unaUbicacion)).thenReturn(true);
        ModificarUbicacionUseCase modificarUbicacionUseCase = new ModificarUbicacionUseCase(iUbicacionRepository);
        boolean resultado = modificarUbicacionUseCase.modificarUbicacion(unaUbicacion);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarUbicacion_HayConflictoUbicacionExiste_UbicacionNoActualiza() {
        Ubicacion unaUbicacion = Ubicacion.instancia(1, "Ubicacion");
        when(iUbicacionRepository.existeUbicacion("Ubicacion")).thenReturn(true);
        when(iUbicacionRepository.guardarUbicacion(unaUbicacion)).thenReturn(false);
        ModificarUbicacionUseCase modificarUbicacionUseCase = new ModificarUbicacionUseCase(iUbicacionRepository);
        Assertions.assertThrows(UbicacionExisteException.class, () -> modificarUbicacionUseCase.modificarUbicacion(unaUbicacion));
    }
}
