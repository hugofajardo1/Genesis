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
        Ubicacion UbicacionNueva = Ubicacion.instancia(1, "Ubicacion");
        when(iUbicacionRepository.existeUbicacion("Ubicacion")).thenReturn(false);
        when(iUbicacionRepository.guardarUbicacion(UbicacionNueva)).thenReturn(true);
        ModificarUbicacionUseCase modificarTipoClienteUseCase = new ModificarUbicacionUseCase(iUbicacionRepository);
        boolean resultado = modificarTipoClienteUseCase.modificarUbicacion(UbicacionNueva);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarUbicacion_HayConflictoUbicacionExiste_UbicacionNoActualiza() {
        Ubicacion UbicacionNueva = Ubicacion.instancia(1, "Ubicacion");
        when(iUbicacionRepository.existeUbicacion("Ubicacion")).thenReturn(true);
        when(iUbicacionRepository.guardarUbicacion(UbicacionNueva)).thenReturn(false);
        ModificarUbicacionUseCase modificarUbicacionUseCase = new ModificarUbicacionUseCase(iUbicacionRepository);
        Assertions.assertThrows(UbicacionExisteException.class, () -> modificarUbicacionUseCase.modificarUbicacion(UbicacionNueva));
    }
}
