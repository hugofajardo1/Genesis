package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.TipoUnidad;
import com.ar.genesis.sistema.core.exception.TipoUnidadNoExisteException;
import com.ar.genesis.sistema.core.repository.ITipoUnidadObtenerPorIdRepository;
import com.ar.genesis.sistema.core.usecase.TipoUnidadObtenerPorIdUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class TipoUnidadObtenerPorIdUseCaseTest {
    @Mock
    ITipoUnidadObtenerPorIdRepository miTipoUnidadObtenerPorIdRepository;

    @Test
    public void obtenerTipoUnidadPorId_devuelveTipoUnidad() throws TipoUnidadNoExisteException {
        TipoUnidad unTipoUnidad = TipoUnidad.instancia(1, "TipoUnidad 1");

        when(miTipoUnidadObtenerPorIdRepository.obtenerTipoUnidad(1)).thenReturn(unTipoUnidad);

        TipoUnidadObtenerPorIdUseCase tipoUnidadObtenerPorIdUseCase = new TipoUnidadObtenerPorIdUseCase(miTipoUnidadObtenerPorIdRepository);
        TipoUnidad resultado = tipoUnidadObtenerPorIdUseCase.obtenerTipoUnidad(1);
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerTipoUnidadPorId_devuelveTipoUnidadNoExiste() throws TipoUnidadNoExisteException {

        when(miTipoUnidadObtenerPorIdRepository.obtenerTipoUnidad(1)).thenReturn(null);

        TipoUnidadObtenerPorIdUseCase tipoUnidadObtenerPorIdUseCase = new TipoUnidadObtenerPorIdUseCase(miTipoUnidadObtenerPorIdRepository);
        Assertions.assertThrows(TipoUnidadNoExisteException.class, () -> tipoUnidadObtenerPorIdUseCase.obtenerTipoUnidad(1));
    }
}