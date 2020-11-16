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
public class CrearTipoFichaUsecaseUnitTest {
    @Mock
    ITipoFichaRepository iTipoFichaRepository;
    @Test
    void crearTipoCliente_TipoClienteNoExiste_GuardaCorrectamente() throws TipoFichaExisteException {
        TipoFicha tipoFichaNuevo = TipoFicha.instancia(1, "Cliente");
        when(iTipoFichaRepository.existeTipoCliente("Cliente")).thenReturn(false);
        when(iTipoFichaRepository.guardarTipoCliente(tipoFichaNuevo)).thenReturn(true);
        CrearTipoFichaUseCase crearTipoClienteUseCase = new CrearTipoFichaUseCase(iTipoFichaRepository);
        boolean resultado = crearTipoClienteUseCase.crearTipoFicha(tipoFichaNuevo);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearTipoCliente_TipoClienteExiste_NoGuardaCliente() {
        TipoFicha tipoFichaNuevo = TipoFicha.instancia(1, "Cliente");
        when(iTipoFichaRepository.existeTipoCliente("Cliente")).thenReturn(true);
        when(iTipoFichaRepository.guardarTipoCliente(tipoFichaNuevo)).thenReturn(false);
        CrearTipoFichaUseCase crearTipoClienteUseCase = new CrearTipoFichaUseCase(iTipoFichaRepository);
        Assertions.assertThrows(TipoFichaExisteException.class, () -> crearTipoClienteUseCase.crearTipoFicha(tipoFichaNuevo));
    }
}
