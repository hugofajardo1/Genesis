package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.core.repository.IObtenerTipoFichasRepository;
import com.ar.genesis.sistema.core.usecase.ObtenerTipoFichasUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class ObtenerTipoFichasUseCaseUT {
    @Mock
    IObtenerTipoFichasRepository iObtenerTipoFichasRepository;
    @Spy
    List<TipoFicha> tipoFichas = factoryListaTipoFichas();

    @Test
    public void obtenerTipoFichas_devuelveLista(){
        when(iObtenerTipoFichasRepository.obtenerTipoFichas()).thenReturn(tipoFichas);
        ObtenerTipoFichasUseCase obtenerTipoFichasUseCase = new ObtenerTipoFichasUseCase(iObtenerTipoFichasRepository);
        List<TipoFicha> resultado = obtenerTipoFichasUseCase.obtenerTipoFichas();
        Assertions.assertEquals(2,resultado.size());
    }

    public List<TipoFicha> factoryListaTipoFichas() {
        List<TipoFicha> losTipoFichas = new ArrayList<>();
        TipoFicha TipoFicha1 = TipoFicha.instancia(1, "Cliente");
        TipoFicha TipoFicha2 = TipoFicha.instancia(2, "Proveedor");
        losTipoFichas.add(TipoFicha1);
        losTipoFichas.add(TipoFicha2);
        return losTipoFichas;
    }
}
