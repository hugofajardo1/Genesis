package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.core.repository.IObtenerTipoIvasRepository;
import com.ar.genesis.sistema.core.usecase.ObtenerTipoIvasUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class ObtenerTipoIvasUseCaseTest {
    @Mock
    IObtenerTipoIvasRepository iObtenerTipoIvasRepository;
    @Spy
    List<TipoIva> tipoIvas = factoryListaTipoIvas();

    @Test
    public void obtenerTipoIvas_devuelveLista(){
        when(iObtenerTipoIvasRepository.obtenerTipoIvas()).thenReturn(tipoIvas);
        ObtenerTipoIvasUseCase obtenerTipoIvasUseCase = new ObtenerTipoIvasUseCase(iObtenerTipoIvasRepository);
        List<TipoIva> resultado = obtenerTipoIvasUseCase.obtenerTipoIvas();
        Assertions.assertEquals(2,resultado.size());
    }

    public List<TipoIva> factoryListaTipoIvas() {
        List<TipoIva> losTipoIvas = new ArrayList<>();
        TipoIva TipoIva1 = TipoIva.instancia(1, "Responsable Inscripto");
        TipoIva TipoIva2 = TipoIva.instancia(2, "Consumidor Final");
        losTipoIvas.add(TipoIva1);
        losTipoIvas.add(TipoIva2);
        return losTipoIvas;
    }
}
