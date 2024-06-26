package com.ar.genesis.sistema.tipoivaTest.usecase;

import com.ar.genesis.sistema.tipoiva.core.domain.TipoIva;
import com.ar.genesis.sistema.tipoiva.core.exception.TipoIvaNoExisteException;
import com.ar.genesis.sistema.tipoiva.core.repository.ITipoIvaObtenerPorIdRepository;
import com.ar.genesis.sistema.tipoiva.core.usecase.TipoIvaObtenerPorIdUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class TipoIvaObtenerPorIdUseCaseTest {
    @Mock
    ITipoIvaObtenerPorIdRepository miTipoIvaObtenerPorIdRepository;

    @Test
    public void obtenerTipoIvaPorId_devuelveTipoIva() throws TipoIvaNoExisteException {
        TipoIva unTipoIva = TipoIva.instancia(1, "TipoIva 1");

        when(miTipoIvaObtenerPorIdRepository.obtenerTipoIva(1)).thenReturn(unTipoIva);

        TipoIvaObtenerPorIdUseCase tipoIvaObtenerPorIdUseCase = new TipoIvaObtenerPorIdUseCase(miTipoIvaObtenerPorIdRepository);
        TipoIva resultado = tipoIvaObtenerPorIdUseCase.obtenerTipoIva(1);
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerTipoIvaPorId_devuelveTipoIvaNoExiste() {

        when(miTipoIvaObtenerPorIdRepository.obtenerTipoIva(1)).thenReturn(null);

        TipoIvaObtenerPorIdUseCase tipoIvaObtenerPorIdUseCase = new TipoIvaObtenerPorIdUseCase(miTipoIvaObtenerPorIdRepository);
        Assertions.assertThrows(TipoIvaNoExisteException.class, () -> tipoIvaObtenerPorIdUseCase.obtenerTipoIva(1));
    }
}