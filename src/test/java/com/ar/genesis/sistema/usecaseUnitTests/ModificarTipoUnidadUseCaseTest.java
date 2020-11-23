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
public class ModificarTipoUnidadUseCaseTest {
    @Mock
    ITipoUnidadRepository iTipoUnidadRepository;
    @Test
    void modificarTipoUnidad_TipoUnidadActualizadoCorrectamente() throws TipoUnidadExisteException {
        TipoUnidad tipoUnidadNueva = TipoUnidad.instancia(1, "Unidad");
        when(iTipoUnidadRepository.existeTipoUnidad("Unidad")).thenReturn(false);
        when(iTipoUnidadRepository.guardarTipoUnidad(tipoUnidadNueva)).thenReturn(true);
        ModificarTipoUnidadUseCase modificarTipoClienteUseCase = new ModificarTipoUnidadUseCase(iTipoUnidadRepository);
        boolean resultado = modificarTipoClienteUseCase.modificarTipoUnidad(tipoUnidadNueva);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarTipoUnidad_HayConflictoTipoUnidadExiste_TipoUnidadNoActualiza() {
        TipoUnidad tipoUnidadNueva = TipoUnidad.instancia(1, "Unidad");
        when(iTipoUnidadRepository.existeTipoUnidad("Unidad")).thenReturn(true);
        when(iTipoUnidadRepository.guardarTipoUnidad(tipoUnidadNueva)).thenReturn(false);
        ModificarTipoUnidadUseCase modificarTipoUnidadUseCase = new ModificarTipoUnidadUseCase(iTipoUnidadRepository);
        Assertions.assertThrows(TipoUnidadExisteException.class, () -> modificarTipoUnidadUseCase.modificarTipoUnidad(tipoUnidadNueva));
    }
}
