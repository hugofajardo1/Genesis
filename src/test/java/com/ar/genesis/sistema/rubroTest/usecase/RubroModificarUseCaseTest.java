package com.ar.genesis.sistema.rubroTest.usecase;

import com.ar.genesis.sistema.rubro.core.domain.Rubro;
import com.ar.genesis.sistema.rubro.core.exception.RubroExisteException;
import com.ar.genesis.sistema.rubro.core.repository.IRubroRepository;
import com.ar.genesis.sistema.rubro.core.usecase.RubroModificarUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class RubroModificarUseCaseTest {
    @Mock
    IRubroRepository miRubroRepository;
    @Test
    void modificarRubro_RubroActualizadoCorrectamente() throws RubroExisteException {
        Rubro unRubro = Rubro.instancia(1, "Rubro");
        when(miRubroRepository.existeRubro("Rubro")).thenReturn(false);
        when(miRubroRepository.guardarRubro(unRubro)).thenReturn(true);
        RubroModificarUseCase rubroModificarUseCase = new RubroModificarUseCase(miRubroRepository);
        boolean resultado = rubroModificarUseCase.modificarRubro(unRubro);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarRubro_HayConflictoRubroExiste_RubroNoActualiza() {
        Rubro unRubro = Rubro.instancia(1, "Rubro");
        when(miRubroRepository.existeRubro("Rubro")).thenReturn(true);
        when(miRubroRepository.guardarRubro(unRubro)).thenReturn(false);
        RubroModificarUseCase rubroModificarUseCase = new RubroModificarUseCase(miRubroRepository);
        Assertions.assertThrows(RubroExisteException.class, () -> rubroModificarUseCase.modificarRubro(unRubro));
    }
}
