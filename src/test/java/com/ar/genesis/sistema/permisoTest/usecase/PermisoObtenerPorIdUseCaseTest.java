package com.ar.genesis.sistema.permisoTest.usecase;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permiso.core.exception.PermisoNoExisteException;
import com.ar.genesis.sistema.permiso.core.repository.IPermisoObtenerPorIdRepository;
import com.ar.genesis.sistema.permiso.core.usecase.PermisoObtenerPorIdUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class PermisoObtenerPorIdUseCaseTest {
    @Mock
    IPermisoObtenerPorIdRepository miPermisoObtenerPorIdRepository;

    @Test
    public void obtenerPermisoPorId_devuelvePermiso() throws PermisoNoExisteException {
        Permiso unPermiso = Permiso.instancia(1, "Permiso 1");

        when(miPermisoObtenerPorIdRepository.obtenerPermiso(1)).thenReturn(unPermiso);

        PermisoObtenerPorIdUseCase permisoObtenerPorIdUseCase = new PermisoObtenerPorIdUseCase(miPermisoObtenerPorIdRepository);
        Permiso resultado = permisoObtenerPorIdUseCase.obtenerPermiso(1);
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerPermisoPorId_devuelvePermisoNoExiste() {

        when(miPermisoObtenerPorIdRepository.obtenerPermiso(1)).thenReturn(null);

        PermisoObtenerPorIdUseCase permisoObtenerPorIdUseCase = new PermisoObtenerPorIdUseCase(miPermisoObtenerPorIdRepository);
        Assertions.assertThrows(PermisoNoExisteException.class, () -> permisoObtenerPorIdUseCase.obtenerPermiso(1));
    }
}