package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.core.repository.ITipoFichaObtenerRepository;
import com.ar.genesis.sistema.core.usecase.TipoFichaObtenerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class TipoFichaObtenerUseCaseTest {
    @Mock
    ITipoFichaObtenerRepository miTipoFichaObtenerRepository;
    @Spy
    List<TipoFicha> tipoFichas = factoryListaTipoFichas();

    @Test
    public void obtenerTipoFichas_devuelveLista(){
        when(miTipoFichaObtenerRepository.obtenerTipoFichas()).thenReturn(tipoFichas);
        TipoFichaObtenerUseCase tipoFichaObtenerUseCase = new TipoFichaObtenerUseCase(miTipoFichaObtenerRepository);
        List<TipoFicha> resultado = tipoFichaObtenerUseCase.obtenerTipoFichas();
        Assertions.assertEquals(2,resultado.size());
    }

    public List<TipoFicha> factoryListaTipoFichas() {
        List<TipoFicha> tipoFichas = new ArrayList<>();
        TipoFicha tipoFicha1 = TipoFicha.instancia(1, "Cliente");
        TipoFicha tipoFicha2 = TipoFicha.instancia(2, "Proveedor");
        tipoFichas.add(tipoFicha1);
        tipoFichas.add(tipoFicha2);
        return tipoFichas;
    }
}
