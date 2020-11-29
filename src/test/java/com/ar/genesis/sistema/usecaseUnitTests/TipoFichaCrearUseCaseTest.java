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
public class TipoFichaCrearUseCaseTest {
    @Mock
    ITipoFichaRepository miTipoFichaRepository;
    @Test
    void crearTipoFicha_TipoFichaNoExiste_GuardaCorrectamente() throws TipoFichaExisteException {
        TipoFicha unTipoFicha = TipoFicha.instancia(1, "Cliente");
        when(miTipoFichaRepository.existeTipoFicha("Cliente")).thenReturn(false);
        when(miTipoFichaRepository.guardarTipoFicha(unTipoFicha)).thenReturn(true);
        CrearTipoFichaUseCase crearTipoFichaUseCase = new CrearTipoFichaUseCase(miTipoFichaRepository);
        boolean resultado = crearTipoFichaUseCase.crearTipoFicha(unTipoFicha);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearTipoFicha_TipoFichaExiste_NoGuardaTipoFicha() {
        TipoFicha unTipoFicha = TipoFicha.instancia(1, "Cliente");
        when(miTipoFichaRepository.existeTipoFicha("Cliente")).thenReturn(true);
        when(miTipoFichaRepository.guardarTipoFicha(unTipoFicha)).thenReturn(false);
        CrearTipoFichaUseCase crearTipoFichaUseCase = new CrearTipoFichaUseCase(miTipoFichaRepository);
        Assertions.assertThrows(TipoFichaExisteException.class, () -> crearTipoFichaUseCase.crearTipoFicha(unTipoFicha));
    }
}
