package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.SubRubro;
import com.ar.genesis.sistema.core.exception.SubRubroExisteException;
import com.ar.genesis.sistema.core.repository.ISubRubroRepository;
import com.ar.genesis.sistema.core.usecase.SubRubroModificarUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class SubRubroModificarUseCaseTest {
    @Mock
    ISubRubroRepository miSubRubroRepository;
    @Test
    void modificarSubRubro_SubRubroActualizadoCorrectamente() throws SubRubroExisteException {
        SubRubro unSubRubro = SubRubro.instancia(1, "SubRubro");
        when(miSubRubroRepository.existeSubRubro("SubRubro")).thenReturn(false);
        when(miSubRubroRepository.guardarSubRubro(unSubRubro)).thenReturn(true);
        SubRubroModificarUseCase subRubroModificarUseCase = new SubRubroModificarUseCase(miSubRubroRepository);
        boolean resultado = subRubroModificarUseCase.modificarSubRubro(unSubRubro);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarSubRubro_HayConflictoSubRubroExiste_SubRubroNoActualiza() {
        SubRubro unSubRubro = SubRubro.instancia(1, "SubRubro");
        when(miSubRubroRepository.existeSubRubro("SubRubro")).thenReturn(true);
        when(miSubRubroRepository.guardarSubRubro(unSubRubro)).thenReturn(false);
        SubRubroModificarUseCase subRubroModificarUseCase = new SubRubroModificarUseCase(miSubRubroRepository);
        Assertions.assertThrows(SubRubroExisteException.class, () -> subRubroModificarUseCase.modificarSubRubro(unSubRubro));
    }
}
