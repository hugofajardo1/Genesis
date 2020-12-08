package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.core.exception.TipoFichaNoExisteException;
import com.ar.genesis.sistema.core.repository.ITipoFichaObtenerPorIdRepository;
import com.ar.genesis.sistema.core.usecase.TipoFichaObtenerPorIdUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class TipoFichaObtenerPorIdUseCaseTest {
    @Mock
    ITipoFichaObtenerPorIdRepository miTipoFichaObtenerPorIdRepository;

    @Test
    public void obtenerTipoFichaPorId_devuelveTipoFicha() throws TipoFichaNoExisteException {
        TipoFicha unTipoFicha = TipoFicha.instancia(1, "TipoFicha 1");

        when(miTipoFichaObtenerPorIdRepository.obtenerTipoFicha(1)).thenReturn(unTipoFicha);

        TipoFichaObtenerPorIdUseCase tipoFichaObtenerPorIdUseCase = new TipoFichaObtenerPorIdUseCase(miTipoFichaObtenerPorIdRepository);
        TipoFicha resultado = tipoFichaObtenerPorIdUseCase.obtenerTipoFicha(1);
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerTipoFichaPorId_devuelveTipoFichaNoExiste() throws TipoFichaNoExisteException {

        when(miTipoFichaObtenerPorIdRepository.obtenerTipoFicha(1)).thenReturn(null);

        TipoFichaObtenerPorIdUseCase tipoFichaObtenerPorIdUseCase = new TipoFichaObtenerPorIdUseCase(miTipoFichaObtenerPorIdRepository);
        Assertions.assertThrows(TipoFichaNoExisteException.class, () -> tipoFichaObtenerPorIdUseCase.obtenerTipoFicha(1));
    }
}