package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.SubRubro;
import com.ar.genesis.sistema.core.repository.IObtenerSubRubrosRepository;
import com.ar.genesis.sistema.core.usecase.ObtenerSubRubrosUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class ObtenerSubRubrosUseCaseUT {
    @Mock
    IObtenerSubRubrosRepository iObtenerSubRubrosRepository;
    @Spy
    List<SubRubro> SubRubros = factoryListaSubRubros();

    @Test
    public void obtenerSubRubros_devuelveLista(){
        when(iObtenerSubRubrosRepository.obtenerSubRubros()).thenReturn(SubRubros);
        ObtenerSubRubrosUseCase obtenerSubRubrosUseCase = new ObtenerSubRubrosUseCase(iObtenerSubRubrosRepository);
        List<SubRubro> resultado = obtenerSubRubrosUseCase.obtenerSubRubros();
        Assertions.assertEquals(2,resultado.size());
    }

    public List<SubRubro> factoryListaSubRubros() {
        List<SubRubro> losSubRubros = new ArrayList<>();
        SubRubro SubRubro1 = SubRubro.instancia(1, "SubRubro 1");
        SubRubro SubRubro2 = SubRubro.instancia(2, "SubRubro 2");
        losSubRubros.add(SubRubro1);
        losSubRubros.add(SubRubro2);
        return losSubRubros;
    }
}
