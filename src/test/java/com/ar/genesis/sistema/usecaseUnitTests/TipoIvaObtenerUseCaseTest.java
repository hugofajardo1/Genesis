package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.core.repository.ITipoIvaObtenerRepository;
import com.ar.genesis.sistema.core.usecase.TipoIvaObtenerUseCase;
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
    ITipoIvaObtenerRepository miTipoIvaObtenerRepository;
    @Spy
    List<TipoIva> tipoIvas = factoryListaTipoIvas();

    @Test
    public void obtenerTipoIvas_devuelveLista(){
        when(miTipoIvaObtenerRepository.obtenerTipoIvas()).thenReturn(tipoIvas);
        TipoIvaObtenerUseCase tipoIvaObtenerUseCase = new TipoIvaObtenerUseCase(miTipoIvaObtenerRepository);
        List<TipoIva> resultado = tipoIvaObtenerUseCase.obtenerTipoIvas();
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
