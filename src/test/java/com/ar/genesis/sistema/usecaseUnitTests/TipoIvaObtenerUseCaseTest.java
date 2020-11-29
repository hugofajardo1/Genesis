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
public class TipoIvaObtenerUseCaseTest {
    @Mock
    IObtenerTipoIvasRepository miObtenerTipoIvasRepository;
    @Spy
    List<TipoIva> tipoIvas = factoryListaTipoIvas();

    @Test
    public void obtenerTipoIvas_devuelveLista(){
        when(miObtenerTipoIvasRepository.obtenerTipoIvas()).thenReturn(tipoIvas);
        ObtenerTipoIvasUseCase obtenerTipoIvasUseCase = new ObtenerTipoIvasUseCase(miObtenerTipoIvasRepository);
        List<TipoIva> resultado = obtenerTipoIvasUseCase.obtenerTipoIvas();
        Assertions.assertEquals(2,resultado.size());
    }

    public List<TipoIva> factoryListaTipoIvas() {
        List<TipoIva> tipoIvas = new ArrayList<>();
        TipoIva tipoIva1 = TipoIva.instancia(1, "Responsable Inscripto");
        TipoIva tipoIva2 = TipoIva.instancia(2, "Consumidor Final");
        tipoIvas.add(tipoIva1);
        tipoIvas.add(tipoIva2);
        return tipoIvas;
    }
}