package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.core.exception.TipoFichaExisteException;
import com.ar.genesis.sistema.core.repository.ITipoFichaRepository;
import com.ar.genesis.sistema.core.usecase.CrearTipoFichaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class CrearTipoFichaUseCaseTest {
    @Mock
    ITipoFichaRepository iTipoFichaRepository;
    @Test
    void crearTipoFicha_TipoFichaNoExiste_GuardaCorrectamente() throws TipoFichaExisteException {
        TipoFicha unTipoFicha = TipoFicha.instancia(1, "Cliente");
        when(iTipoFichaRepository.existeTipoFicha("Cliente")).thenReturn(false);
        when(iTipoFichaRepository.guardarTipoFicha(unTipoFicha)).thenReturn(true);
        CrearTipoFichaUseCase crearTipoFichaUseCase = new CrearTipoFichaUseCase(iTipoFichaRepository);
        boolean resultado = crearTipoFichaUseCase.crearTipoFicha(unTipoFicha);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearTipoFicha_TipoFichaExiste_NoGuardaTipoFicha() {
        TipoFicha unTipoFicha = TipoFicha.instancia(1, "Cliente");
        when(iTipoFichaRepository.existeTipoFicha("Cliente")).thenReturn(true);
        when(iTipoFichaRepository.guardarTipoFicha(unTipoFicha)).thenReturn(false);
        CrearTipoFichaUseCase crearTipoFichaUseCase = new CrearTipoFichaUseCase(iTipoFichaRepository);
        Assertions.assertThrows(TipoFichaExisteException.class, () -> crearTipoFichaUseCase.crearTipoFicha(unTipoFicha));
    }
}
