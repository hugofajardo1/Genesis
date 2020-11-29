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
public class ObtenerTipoFichasUseCaseTest {
    @Mock
    IObtenerTipoFichasRepository miObtenerTipoFichasRepository;
    @Spy
    List<TipoFicha> tipoFichas = factoryListaTipoFichas();

    @Test
    public void obtenerTipoFichas_devuelveLista(){
        when(miObtenerTipoFichasRepository.obtenerTipoFichas()).thenReturn(tipoFichas);
        ObtenerTipoFichasUseCase obtenerTipoFichasUseCase = new ObtenerTipoFichasUseCase(miObtenerTipoFichasRepository);
        List<TipoFicha> resultado = obtenerTipoFichasUseCase.obtenerTipoFichas();
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
