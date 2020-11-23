package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Rubro;
import com.ar.genesis.sistema.core.repository.IObtenerRubrosRepository;
import com.ar.genesis.sistema.core.usecase.ObtenerRubrosUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class ObtenerRubrosUseCaseTest {
    @Mock
    IObtenerRubrosRepository iObtenerRubrosRepository;
    @Spy
    List<Rubro> Rubros = factoryListaRubros();

    @Test
    public void obtenerRubros_devuelveLista(){
        when(iObtenerRubrosRepository.obtenerRubros()).thenReturn(Rubros);
        ObtenerRubrosUseCase obtenerRubrosUseCase = new ObtenerRubrosUseCase(iObtenerRubrosRepository);
        List<Rubro> resultado = obtenerRubrosUseCase.obtenerRubros();
        Assertions.assertEquals(2,resultado.size());
    }

    public List<Rubro> factoryListaRubros() {
        List<Rubro> losRubros = new ArrayList<>();
        Rubro Rubro1 = Rubro.instancia(1, "Rubro 1");
        Rubro Rubro2 = Rubro.instancia(2, "Rubro 2");
        losRubros.add(Rubro1);
        losRubros.add(Rubro2);
        return losRubros;
    }
}
