package com.ar.genesis.sistema.permisoTest.usecase;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permiso.core.repository.IPermisoObtenerRepository;
import com.ar.genesis.sistema.permiso.core.usecase.PermisoObtenerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class PermisoObtenerUseCaseTest {
    @Mock
    IPermisoObtenerRepository miPermisoObtenerRepository;
    @Spy
    List<Permiso> permisos = factoryListaPermisos();

    @Test
    public void obtenerPermisos_devuelveLista(){
        when(miPermisoObtenerRepository.obtenerPermisos()).thenReturn(permisos);
        PermisoObtenerUseCase permisoObtenerUseCase = new PermisoObtenerUseCase(miPermisoObtenerRepository);
        List<Permiso> resultado = permisoObtenerUseCase.obtenerPermisos();
        Assertions.assertEquals(2,resultado.size());
    }

    public List<Permiso> factoryListaPermisos() {
        List<Permiso> permisos = new ArrayList<>();
        Permiso permiso1 = Permiso.instancia(1, "Permiso 1");
        Permiso permiso2 = Permiso.instancia(2, "Permiso 2");
        permisos.add(permiso1);
        permisos.add(permiso2);
        return permisos;
    }
}
