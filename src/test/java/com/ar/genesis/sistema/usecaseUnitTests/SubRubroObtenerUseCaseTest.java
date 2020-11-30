package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.SubRubro;
import com.ar.genesis.sistema.core.repository.ISubRubroObtenerRepository;
import com.ar.genesis.sistema.core.usecase.SubRubroUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class SubRubroObtenerUseCaseTest {
    @Mock
    ISubRubroObtenerRepository miSubRubroObtenerRepository;
    @Spy
    List<SubRubro> SubRubros = factoryListaSubRubros();

    @Test
    public void obtenerSubRubros_devuelveLista(){
        when(miSubRubroObtenerRepository.obtenerSubRubros()).thenReturn(SubRubros);
        SubRubroUseCase subRubroObtenerUseCase = new SubRubroUseCase(miSubRubroObtenerRepository);
        List<SubRubro> resultado = subRubroObtenerUseCase.obtenerSubRubros();
        Assertions.assertEquals(2,resultado.size());
    }

    public List<SubRubro> factoryListaSubRubros() {
        List<SubRubro> subRubros = new ArrayList<>();
        SubRubro subRubro1 = SubRubro.instancia(1, "SubRubro 1");
        SubRubro subRubro2 = SubRubro.instancia(2, "SubRubro 2");
        subRubros.add(subRubro1);
        subRubros.add(subRubro2);
        return subRubros;
    }
}
