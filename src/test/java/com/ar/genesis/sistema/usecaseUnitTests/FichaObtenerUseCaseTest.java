package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Ficha;
import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.core.repository.IObtenerFichasRepository;
import com.ar.genesis.sistema.core.usecase.FichaObtenerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class FichaObtenerUseCaseTest {
    @Mock
    IObtenerFichasRepository miObtenerFichasRepository;

    @Spy
    List<Ficha> fichas = factoryListaFichas();

    @Test
    public void obtenerFichas_devuelveLista(){
        when(miObtenerFichasRepository.obtenerFichas()).thenReturn(fichas);
        FichaObtenerUseCase obtenerFichasUseCase = new FichaObtenerUseCase(miObtenerFichasRepository);
        List<Ficha> resultado = obtenerFichasUseCase.obtenerFichas();
        Assertions.assertEquals(2,resultado.size());
    }

    public List<Ficha> factoryListaFichas() {
        List<Ficha> fichas = new ArrayList<>();
        Ficha ficha1 = Ficha.instancia(1, "Fajardo, Hugo", "Bs As 245", "3825416543", TipoIva.instancia(1, "Responsable Inscripto"), "20255071336");
        Ficha ficha2 = Ficha.instancia(2, "Fajardo, Lourdes", "Juan XXIII 59", "5453454", TipoIva.instancia(1, "Responsable Inscripto"), "20255071336");
        fichas.add(ficha1);
        fichas.add(ficha2);
        return fichas;
    }
}
