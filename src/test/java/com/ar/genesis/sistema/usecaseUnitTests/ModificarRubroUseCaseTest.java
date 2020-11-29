package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Rubro;
import com.ar.genesis.sistema.core.exception.RubroExisteException;
import com.ar.genesis.sistema.core.repository.IRubroRepository;
import com.ar.genesis.sistema.core.usecase.ModificarRubroUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class ModificarRubroUseCaseTest {
    @Mock
    IRubroRepository miRubroRepository;
    @Test
    void modificarRubro_RubroActualizadoCorrectamente() throws RubroExisteException {
        Rubro unRubro = Rubro.instancia(1, "Rubro");
        when(miRubroRepository.existeRubro("Rubro")).thenReturn(false);
        when(miRubroRepository.guardarRubro(unRubro)).thenReturn(true);
        ModificarRubroUseCase modificarRubroUseCase = new ModificarRubroUseCase(miRubroRepository);
        boolean resultado = modificarRubroUseCase.modificarRubro(unRubro);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarRubro_HayConflictoRubroExiste_RubroNoActualiza() {
        Rubro unRubro = Rubro.instancia(1, "Rubro");
        when(miRubroRepository.existeRubro("Rubro")).thenReturn(true);
        when(miRubroRepository.guardarRubro(unRubro)).thenReturn(false);
        ModificarRubroUseCase modificarRubroUseCase = new ModificarRubroUseCase(miRubroRepository);
        Assertions.assertThrows(RubroExisteException.class, () -> modificarRubroUseCase.modificarRubro(unRubro));
    }
}
