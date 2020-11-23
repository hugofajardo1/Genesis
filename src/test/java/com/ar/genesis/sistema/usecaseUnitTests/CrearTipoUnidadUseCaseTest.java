package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.TipoUnidad;
import com.ar.genesis.sistema.core.exception.TipoUnidadExisteException;
import com.ar.genesis.sistema.core.repository.ITipoUnidadRepository;
import com.ar.genesis.sistema.core.usecase.CrearTipoUnidadUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class CrearTipoUnidadUseCaseTest {
    @Mock
    ITipoUnidadRepository iTipoUnidadRepository;
    @Test
    void crearTipoUnidad_TipoUnidadNoExiste_GuardaCorrectamente() throws TipoUnidadExisteException {
        TipoUnidad unTipoUnidad = TipoUnidad.instancia(1, "Unidad");
        when(iTipoUnidadRepository.existeTipoUnidad("Unidad")).thenReturn(false);
        when(iTipoUnidadRepository.guardarTipoUnidad(unTipoUnidad)).thenReturn(true);
        CrearTipoUnidadUseCase crearTipoUnidadUseCase = new CrearTipoUnidadUseCase(iTipoUnidadRepository);
        boolean resultado = crearTipoUnidadUseCase.crearTipoUnidad(unTipoUnidad);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearTipoUnidad_TipoUnidadExiste_NoGuardaTipoUnidad() {
        TipoUnidad unTipoUnidad = TipoUnidad.instancia(1, "Unidad");
        when(iTipoUnidadRepository.existeTipoUnidad("Unidad")).thenReturn(true);
        when(iTipoUnidadRepository.guardarTipoUnidad(unTipoUnidad)).thenReturn(false);
        CrearTipoUnidadUseCase crearTipoUnidadUseCase = new CrearTipoUnidadUseCase(iTipoUnidadRepository);
        Assertions.assertThrows(TipoUnidadExisteException.class, () -> crearTipoUnidadUseCase.crearTipoUnidad(unTipoUnidad));
    }
}
