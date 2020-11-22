package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.SubRubro;
import com.ar.genesis.sistema.core.exception.SubRubroExisteException;
import com.ar.genesis.sistema.core.repository.ISubRubroRepository;
import com.ar.genesis.sistema.core.usecase.ModificarSubRubroUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class ModificarSubRubroUseCaseUT {
    @Mock
    ISubRubroRepository iSubRubroRepository;
    @Test
    void modificarSubRubro_SubRubroActualizadoCorrectamente() throws SubRubroExisteException {
        SubRubro SubRubroNueva = SubRubro.instancia(1, "SubRubro");
        when(iSubRubroRepository.existeSubRubro("SubRubro")).thenReturn(false);
        when(iSubRubroRepository.guardarSubRubro(SubRubroNueva)).thenReturn(true);
        ModificarSubRubroUseCase modificarTipoClienteUseCase = new ModificarSubRubroUseCase(iSubRubroRepository);
        boolean resultado = modificarTipoClienteUseCase.modificarSubRubro(SubRubroNueva);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarSubRubro_HayConflictoSubRubroExiste_SubRubroNoActualiza() {
        SubRubro SubRubroNueva = SubRubro.instancia(1, "SubRubro");
        when(iSubRubroRepository.existeSubRubro("SubRubro")).thenReturn(true);
        when(iSubRubroRepository.guardarSubRubro(SubRubroNueva)).thenReturn(false);
        ModificarSubRubroUseCase modificarSubRubroUseCase = new ModificarSubRubroUseCase(iSubRubroRepository);
        Assertions.assertThrows(SubRubroExisteException.class, () -> modificarSubRubroUseCase.modificarSubRubro(SubRubroNueva));
    }
}
