package com.ar.genesis.sistema.tipofichaTest.usecase;

import com.ar.genesis.sistema.tipoficha.core.domain.TipoFicha;
import com.ar.genesis.sistema.tipoficha.core.exception.TipoFichaExisteException;
import com.ar.genesis.sistema.tipoficha.core.repository.ITipoFichaRepository;
import com.ar.genesis.sistema.tipoficha.core.usecase.TipoFichaCrearUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class TipoFichaCrearUseCaseTest {
    @Mock
    ITipoFichaRepository miTipoFichaRepository;
    @Test
    void crearTipoFicha_TipoFichaNoExiste_GuardaCorrectamente() throws TipoFichaExisteException {
        TipoFicha unTipoFicha = TipoFicha.instancia(1, "Cliente");
        when(miTipoFichaRepository.existeTipoFicha("Cliente")).thenReturn(false);
        when(miTipoFichaRepository.guardarTipoFicha(unTipoFicha)).thenReturn(true);
        TipoFichaCrearUseCase tipoFichaCrearUseCase = new TipoFichaCrearUseCase(miTipoFichaRepository);
        boolean resultado = tipoFichaCrearUseCase.crearTipoFicha(unTipoFicha);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearTipoFicha_TipoFichaExiste_NoGuardaTipoFicha() {
        TipoFicha unTipoFicha = TipoFicha.instancia(1, "Cliente");
        when(miTipoFichaRepository.existeTipoFicha("Cliente")).thenReturn(true);
        when(miTipoFichaRepository.guardarTipoFicha(unTipoFicha)).thenReturn(false);
        TipoFichaCrearUseCase tipoFichaCrearUseCase = new TipoFichaCrearUseCase(miTipoFichaRepository);
        Assertions.assertThrows(TipoFichaExisteException.class, () -> tipoFichaCrearUseCase.crearTipoFicha(unTipoFicha));
    }
}
