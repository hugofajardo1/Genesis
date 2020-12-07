package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Ubicacion;
import com.ar.genesis.sistema.core.exception.UbicacionNoExisteException;
import com.ar.genesis.sistema.core.repository.IUbicacionObtenerPorIdRepository;
import com.ar.genesis.sistema.core.usecase.UbicacionObtenerPorIdUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class UbicacionObtenerPorIdUseCaseTest {
    @Mock
    IUbicacionObtenerPorIdRepository miUbicacionObtenerPorIdRepository;

    @Test
    public void obtenerUbicacionPorId_devuelveUbicacion() throws UbicacionNoExisteException {
        Ubicacion unaUbicacion = Ubicacion.instancia(1, "Ubicacion 1");

        when(miUbicacionObtenerPorIdRepository.obtenerUbicacion(1)).thenReturn(unaUbicacion);

        UbicacionObtenerPorIdUseCase ubicacionObtenerPorIdUseCase = new UbicacionObtenerPorIdUseCase(miUbicacionObtenerPorIdRepository);
        Ubicacion resultado = ubicacionObtenerPorIdUseCase.obtenerUbicacion(1);
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerUbicacionPorId_devuelveUbicacionNoExiste() throws UbicacionNoExisteException {

        when(miUbicacionObtenerPorIdRepository.obtenerUbicacion(1)).thenReturn(null);

        UbicacionObtenerPorIdUseCase ubicacionObtenerPorIdUseCase = new UbicacionObtenerPorIdUseCase(miUbicacionObtenerPorIdRepository);
        Assertions.assertThrows(UbicacionNoExisteException.class, () -> ubicacionObtenerPorIdUseCase.obtenerUbicacion(1));
    }
}