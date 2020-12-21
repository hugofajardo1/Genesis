package com.ar.genesis.sistema.permisoTest.usecase;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permiso.core.exception.PermisoExisteException;
import com.ar.genesis.sistema.permiso.core.repository.IPermisoRepository;
import com.ar.genesis.sistema.permiso.core.usecase.PermisoModificarUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class PermisoModificarUseCaseTest {
    @Mock
    IPermisoRepository miPermisoRepository;
    @Test
    void modificarPermiso_PermisoActualizadoCorrectamente() throws PermisoExisteException {
        Permiso unPermiso = Permiso.instancia(1, "Permiso");
        when(miPermisoRepository.existePermiso("Permiso")).thenReturn(false);
        when(miPermisoRepository.guardarPermiso(unPermiso)).thenReturn(true);
        PermisoModificarUseCase permisoModificarUseCase = new PermisoModificarUseCase(miPermisoRepository);
        boolean resultado = permisoModificarUseCase.modificarPermiso(unPermiso);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarPermiso_HayConflictoPermisoExiste_PermisoNoActualiza() {
        Permiso unPermiso = Permiso.instancia(1, "Permiso");
        when(miPermisoRepository.existePermiso("Permiso")).thenReturn(true);
        when(miPermisoRepository.guardarPermiso(unPermiso)).thenReturn(false);
        PermisoModificarUseCase permisoModificarUseCase = new PermisoModificarUseCase(miPermisoRepository);
        Assertions.assertThrows(PermisoExisteException.class, () -> permisoModificarUseCase.modificarPermiso(unPermiso));
    }
}
