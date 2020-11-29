package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.core.exception.TipoFichaExisteException;
import com.ar.genesis.sistema.core.repository.ITipoFichaRepository;
import com.ar.genesis.sistema.core.usecase.ModificarTipoFichaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class ModificarTipoFichaUseCaseTest {
    @Mock
    ITipoFichaRepository miTipoFichaRepository;
    @Test
    void modificarTipoFicha_TipoFichaActualizadoCorrectamente() throws TipoFichaExisteException {
        TipoFicha unTipoFicha = TipoFicha.instancia(1, "Cliente");
        when(miTipoFichaRepository.existeTipoFicha("Cliente")).thenReturn(false);
        when(miTipoFichaRepository.guardarTipoFicha(unTipoFicha)).thenReturn(true);
        ModificarTipoFichaUseCase modificarTipoFichaUseCase = new ModificarTipoFichaUseCase(miTipoFichaRepository);
        boolean resultado = modificarTipoFichaUseCase.modificarTipoFicha(unTipoFicha);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarTipoFicha_HayConflictoTipoFichaExiste_TipoFichaNoActualiza() {
        TipoFicha unTipoFicha = TipoFicha.instancia(1, "Cliente");
        when(miTipoFichaRepository.existeTipoFicha("Cliente")).thenReturn(true);
        when(miTipoFichaRepository.guardarTipoFicha(unTipoFicha)).thenReturn(false);
        ModificarTipoFichaUseCase modificarTipoFichaUseCase = new ModificarTipoFichaUseCase(miTipoFichaRepository);
        Assertions.assertThrows(TipoFichaExisteException.class, () -> modificarTipoFichaUseCase.modificarTipoFicha(unTipoFicha));
    }
}
