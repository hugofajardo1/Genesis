package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Rubro;
import com.ar.genesis.sistema.core.exception.RubroExisteException;
import com.ar.genesis.sistema.core.repository.IRubroRepository;
import com.ar.genesis.sistema.core.usecase.RubroCrearUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class RubroCrearUseCaseTest {
    @Mock
    IRubroRepository miRubroRepository;
    @Test
    void crearTipoRubro_RubroNoExiste_GuardaCorrectamente() throws RubroExisteException {
        Rubro unRubro = Rubro.instancia(1, "Rubro");
        when(miRubroRepository.existeRubro("Rubro")).thenReturn(false);
        when(miRubroRepository.guardarRubro(unRubro)).thenReturn(true);
        RubroCrearUseCase rubroCrearUseCase = new RubroCrearUseCase(miRubroRepository);
        boolean resultado = rubroCrearUseCase.crearRubro(unRubro);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearTipoRubro_RubroExiste_NoGuardaTipoRubro() {
        Rubro unRubro = Rubro.instancia(1, "Rubro");
        when(miRubroRepository.existeRubro("Rubro")).thenReturn(true);
        when(miRubroRepository.guardarRubro(unRubro)).thenReturn(false);
        RubroCrearUseCase rubroCrearUseCase = new RubroCrearUseCase(miRubroRepository);
        Assertions.assertThrows(RubroExisteException.class, () -> rubroCrearUseCase.crearRubro(unRubro));
    }
}
