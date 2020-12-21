package com.ar.genesis.sistema.permisoTest.usecase;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permiso.core.exception.PermisoExisteException;
import com.ar.genesis.sistema.permiso.core.repository.IPermisoRepository;
import com.ar.genesis.sistema.permiso.core.usecase.PermisoCrearUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class PermisoCrearUseCaseTest {
    @Mock
    IPermisoRepository miPermisoRepository;
    @Test
    void crearPermiso_PermisoNoExiste_GuardaCorrectamente() throws PermisoExisteException {
        Permiso unPermiso = Permiso.instancia(1, "Permiso");
        when(miPermisoRepository.existePermiso("Permiso")).thenReturn(false);
        when(miPermisoRepository.guardarPermiso(unPermiso)).thenReturn(true);
        PermisoCrearUseCase permisoCrearUseCase = new PermisoCrearUseCase(miPermisoRepository);
        boolean resultado = permisoCrearUseCase.crearPermiso(unPermiso);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearPermiso_PermisoExiste_NoGuardaPermiso() {
        Permiso unPermiso = Permiso.instancia(1, "Permiso");
        when(miPermisoRepository.existePermiso("Permiso")).thenReturn(true);
        when(miPermisoRepository.guardarPermiso(unPermiso)).thenReturn(false);
        PermisoCrearUseCase permisoCrearUseCase = new PermisoCrearUseCase(miPermisoRepository);
        Assertions.assertThrows(PermisoExisteException.class, () -> permisoCrearUseCase.crearPermiso(unPermiso));
    }
}
