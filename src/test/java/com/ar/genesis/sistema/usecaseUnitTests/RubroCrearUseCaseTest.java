package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Rubro;
import com.ar.genesis.sistema.core.exception.RubroExisteException;
import com.ar.genesis.sistema.core.repository.IRubroRepository;
import com.ar.genesis.sistema.core.usecase.CrearRubroUseCase;
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
        CrearRubroUseCase crearRubroUseCase = new CrearRubroUseCase(miRubroRepository);
        boolean resultado = crearRubroUseCase.crearRubro(unRubro);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearTipoRubro_RubroExiste_NoGuardaTipoRubro() {
        Rubro unRubro = Rubro.instancia(1, "Rubro");
        when(miRubroRepository.existeRubro("Rubro")).thenReturn(true);
        when(miRubroRepository.guardarRubro(unRubro)).thenReturn(false);
        CrearRubroUseCase crearRubroUseCase = new CrearRubroUseCase(miRubroRepository);
        Assertions.assertThrows(RubroExisteException.class, () -> crearRubroUseCase.crearRubro(unRubro));
    }
}