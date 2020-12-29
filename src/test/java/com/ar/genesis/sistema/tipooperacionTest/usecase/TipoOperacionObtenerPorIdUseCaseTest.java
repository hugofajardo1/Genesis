package com.ar.genesis.sistema.tipooperacionTest.usecase;

import com.ar.genesis.sistema.tipooperacion.core.domain.TipoOperacion;
import com.ar.genesis.sistema.tipooperacion.core.exception.TipoOperacionNoExisteException;
import com.ar.genesis.sistema.tipooperacion.core.repository.ITipoOperacionObtenerPorIdRepository;
import com.ar.genesis.sistema.tipooperacion.core.usecase.TipoOperacionObtenerPorIdUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class TipoOperacionObtenerPorIdUseCaseTest {
    @Mock
    ITipoOperacionObtenerPorIdRepository miTipoOperacionObtenerPorIdRepository;

    @Test
    public void obtenerTipoOperacionPorId_devuelveTipoOperacion() throws TipoOperacionNoExisteException {
        TipoOperacion unTipoOperacion = TipoOperacion.instancia(1, "Venta");

        when(miTipoOperacionObtenerPorIdRepository.obtenerTipoOperacion(1)).thenReturn(unTipoOperacion);

        TipoOperacionObtenerPorIdUseCase tipoOperacionObtenerPorIdUseCase = new TipoOperacionObtenerPorIdUseCase(miTipoOperacionObtenerPorIdRepository);
        TipoOperacion resultado = tipoOperacionObtenerPorIdUseCase.obtenerTipoOperacion(1);
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerTipoOperacionPorId_devuelveTipoOperacionNoExiste() {

        when(miTipoOperacionObtenerPorIdRepository.obtenerTipoOperacion(1)).thenReturn(null);

        TipoOperacionObtenerPorIdUseCase tipoOperacionObtenerPorIdUseCase = new TipoOperacionObtenerPorIdUseCase(miTipoOperacionObtenerPorIdRepository);
        Assertions.assertThrows(TipoOperacionNoExisteException.class, () -> tipoOperacionObtenerPorIdUseCase.obtenerTipoOperacion(1));
    }
}