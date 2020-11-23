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
public class CrearRubroUseCaseTest {
    @Mock
    IRubroRepository iRubroRepository;
    @Test
    void crearTipoRubro_RubroNoExiste_GuardaCorrectamente() throws RubroExisteException {
        Rubro RubroNueva = Rubro.instancia(1, "Rubro");
        when(iRubroRepository.existeRubro("Rubro")).thenReturn(false);
        when(iRubroRepository.guardarRubro(RubroNueva)).thenReturn(true);
        CrearRubroUseCase crearTipoRubroUseCase = new CrearRubroUseCase(iRubroRepository);
        boolean resultado = crearTipoRubroUseCase.crearRubro(RubroNueva);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearTipoRubro_RubroExiste_NoGuardaTipoRubro() {
        Rubro RubroNueva = Rubro.instancia(1, "Rubro");
        when(iRubroRepository.existeRubro("Rubro")).thenReturn(true);
        when(iRubroRepository.guardarRubro(RubroNueva)).thenReturn(false);
        CrearRubroUseCase crearTipoRubroUseCase = new CrearRubroUseCase(iRubroRepository);
        Assertions.assertThrows(RubroExisteException.class, () -> crearTipoRubroUseCase.crearRubro(RubroNueva));
    }
}
