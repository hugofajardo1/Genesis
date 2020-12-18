package com.ar.genesis.sistema.tipofichaTest.usecase;

import com.ar.genesis.sistema.tipoficha.core.domain.TipoFicha;
import com.ar.genesis.sistema.tipoficha.core.exception.TipoFichaExisteException;
import com.ar.genesis.sistema.tipoficha.core.repository.ITipoFichaRepository;
import com.ar.genesis.sistema.tipoficha.core.usecase.TipoFichaModificarUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class TipoFichaModificarUseCaseTest {
    @Mock
    ITipoFichaRepository miTipoFichaRepository;
    @Test
    void modificarTipoFicha_TipoFichaActualizadoCorrectamente() throws TipoFichaExisteException {
        TipoFicha unTipoFicha = TipoFicha.instancia(1, "Cliente");
        when(miTipoFichaRepository.existeTipoFicha("Cliente")).thenReturn(false);
        when(miTipoFichaRepository.guardarTipoFicha(unTipoFicha)).thenReturn(true);
        TipoFichaModificarUseCase tipoFichaModificarUseCase = new TipoFichaModificarUseCase(miTipoFichaRepository);
        boolean resultado = tipoFichaModificarUseCase.modificarTipoFicha(unTipoFicha);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarTipoFicha_HayConflictoTipoFichaExiste_TipoFichaNoActualiza() {
        TipoFicha unTipoFicha = TipoFicha.instancia(1, "Cliente");
        when(miTipoFichaRepository.existeTipoFicha("Cliente")).thenReturn(true);
        when(miTipoFichaRepository.guardarTipoFicha(unTipoFicha)).thenReturn(false);
        TipoFichaModificarUseCase tipoFichaModificarUseCase = new TipoFichaModificarUseCase(miTipoFichaRepository);
        Assertions.assertThrows(TipoFichaExisteException.class, () -> tipoFichaModificarUseCase.modificarTipoFicha(unTipoFicha));
    }
}
