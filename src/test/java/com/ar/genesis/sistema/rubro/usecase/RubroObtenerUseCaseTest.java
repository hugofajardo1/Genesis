package com.ar.genesis.sistema.rubro.usecase;

import com.ar.genesis.sistema.rubro.core.domain.Rubro;
import com.ar.genesis.sistema.rubro.core.repository.IRubroObtenerRepository;
import com.ar.genesis.sistema.rubro.core.usecase.RubroObtenerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class RubroObtenerUseCaseTest {
    @Mock
    IRubroObtenerRepository miRubroObtenerRepository;
    @Spy
    List<Rubro> Rubros = factoryListaRubros();

    @Test
    public void obtenerRubros_devuelveLista(){
        when(miRubroObtenerRepository.obtenerRubros()).thenReturn(Rubros);
        RubroObtenerUseCase rubroObtenerUseCase = new RubroObtenerUseCase(miRubroObtenerRepository);
        List<Rubro> resultado = rubroObtenerUseCase.obtenerRubros();
        Assertions.assertEquals(2,resultado.size());
    }

    public List<Rubro> factoryListaRubros() {
        List<Rubro> rubros = new ArrayList<>();
        Rubro rubro1 = Rubro.instancia(1, "Rubro 1");
        Rubro rubro2 = Rubro.instancia(2, "Rubro 2");
        rubros.add(rubro1);
        rubros.add(rubro2);
        return rubros;
    }
}
