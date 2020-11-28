package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.core.exception.TipoFichaExisteException;
import com.ar.genesis.sistema.core.repository.ITipoFichaRepository;
import com.ar.genesis.sistema.core.usecase.CrearTipoFichaUseCase;
import com.ar.genesis.sistema.core.usecase.ModificarTipoFichaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class ModificarTipoFichaUseCaseTest {
    @Mock
    ITipoFichaRepository iTipoFichaRepository;
    @Test
    void modificarTipoFicha_TipoFichaActualizadoCorrectamente() throws TipoFichaExisteException {
        TipoFicha tipoFichaNueva = TipoFicha.instancia(1, "Cliente");
        when(iTipoFichaRepository.existeTipoFicha("Cliente")).thenReturn(false);
        when(iTipoFichaRepository.guardarTipoFicha(tipoFichaNueva)).thenReturn(true);
        ModificarTipoFichaUseCase modificarTipoFichaUseCase = new ModificarTipoFichaUseCase(iTipoFichaRepository);
        boolean resultado = modificarTipoFichaUseCase.modificarTipoFicha(tipoFichaNueva);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarTipoFicha_HayConflictoTipoFichaExiste_TipoFichaNoActualiza() {
        TipoFicha tipoFichaNueva = TipoFicha.instancia(1, "Cliente");
        when(iTipoFichaRepository.existeTipoFicha("Cliente")).thenReturn(true);
        when(iTipoFichaRepository.guardarTipoFicha(tipoFichaNueva)).thenReturn(false);
        ModificarTipoFichaUseCase modificarTipoFichaUseCase = new ModificarTipoFichaUseCase(iTipoFichaRepository);
        Assertions.assertThrows(TipoFichaExisteException.class, () -> modificarTipoFichaUseCase.modificarTipoFicha(tipoFichaNueva));
    }
}
