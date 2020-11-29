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
    IRubroRepository iRubroRepository;
    @Test
    void modificarRubro_RubroActualizadoCorrectamente() throws RubroExisteException {
        Rubro unRubro = Rubro.instancia(1, "Rubro");
        when(iRubroRepository.existeRubro("Rubro")).thenReturn(false);
        when(iRubroRepository.guardarRubro(unRubro)).thenReturn(true);
        ModificarRubroUseCase modificarRubroUseCase = new ModificarRubroUseCase(iRubroRepository);
        boolean resultado = modificarRubroUseCase.modificarRubro(unRubro);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarRubro_HayConflictoRubroExiste_RubroNoActualiza() {
        Rubro unRubro = Rubro.instancia(1, "Rubro");
        when(iRubroRepository.existeRubro("Rubro")).thenReturn(true);
        when(iRubroRepository.guardarRubro(unRubro)).thenReturn(false);
        ModificarRubroUseCase modificarRubroUseCase = new ModificarRubroUseCase(iRubroRepository);
        Assertions.assertThrows(RubroExisteException.class, () -> modificarRubroUseCase.modificarRubro(unRubro));
    }
}
