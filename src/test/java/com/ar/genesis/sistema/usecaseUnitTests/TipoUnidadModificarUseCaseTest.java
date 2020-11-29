package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.TipoUnidad;
import com.ar.genesis.sistema.core.exception.TipoUnidadExisteException;
import com.ar.genesis.sistema.core.repository.ITipoUnidadRepository;
import com.ar.genesis.sistema.core.usecase.ModificarTipoUnidadUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class TipoUnidadModificarUseCaseTest {
    @Mock
    ITipoUnidadRepository miTipoUnidadRepository;
    @Test
    void modificarTipoUnidad_TipoUnidadActualizadoCorrectamente() throws TipoUnidadExisteException {
        TipoUnidad unTipoUnidad = TipoUnidad.instancia(1, "Unidad");
        when(miTipoUnidadRepository.existeTipoUnidad("Unidad")).thenReturn(false);
        when(miTipoUnidadRepository.guardarTipoUnidad(unTipoUnidad)).thenReturn(true);
        ModificarTipoUnidadUseCase modificarTipoUnidadUseCase = new ModificarTipoUnidadUseCase(miTipoUnidadRepository);
        boolean resultado = modificarTipoUnidadUseCase.modificarTipoUnidad(unTipoUnidad);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarTipoUnidad_HayConflictoTipoUnidadExiste_TipoUnidadNoActualiza() {
        TipoUnidad unTipoUnidad = TipoUnidad.instancia(1, "Unidad");
        when(miTipoUnidadRepository.existeTipoUnidad("Unidad")).thenReturn(true);
        when(miTipoUnidadRepository.guardarTipoUnidad(unTipoUnidad)).thenReturn(false);
        ModificarTipoUnidadUseCase modificarTipoUnidadUseCase = new ModificarTipoUnidadUseCase(miTipoUnidadRepository);
        Assertions.assertThrows(TipoUnidadExisteException.class, () -> modificarTipoUnidadUseCase.modificarTipoUnidad(unTipoUnidad));
    }
}
