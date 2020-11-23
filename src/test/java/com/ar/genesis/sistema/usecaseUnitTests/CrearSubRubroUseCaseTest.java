package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.SubRubro;
import com.ar.genesis.sistema.core.exception.SubRubroExisteException;
import com.ar.genesis.sistema.core.repository.ISubRubroRepository;
import com.ar.genesis.sistema.core.usecase.CrearSubRubroUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class CrearSubRubroUseCaseTest {
    @Mock
    ISubRubroRepository iSubRubroRepository;
    @Test
    void crearTipoSubRubro_SubRubroNoExiste_GuardaCorrectamente() throws SubRubroExisteException {
        SubRubro SubRubroNueva = SubRubro.instancia(1, "SubRubro");
        when(iSubRubroRepository.existeSubRubro("SubRubro")).thenReturn(false);
        when(iSubRubroRepository.guardarSubRubro(SubRubroNueva)).thenReturn(true);
        CrearSubRubroUseCase crearTipoSubRubroUseCase = new CrearSubRubroUseCase(iSubRubroRepository);
        boolean resultado = crearTipoSubRubroUseCase.crearSubRubro(SubRubroNueva);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearTipoSubRubro_SubRubroExiste_NoGuardaTipoSubRubro() {
        SubRubro SubRubroNueva = SubRubro.instancia(1, "SubRubro");
        when(iSubRubroRepository.existeSubRubro("SubRubro")).thenReturn(true);
        when(iSubRubroRepository.guardarSubRubro(SubRubroNueva)).thenReturn(false);
        CrearSubRubroUseCase crearTipoSubRubroUseCase = new CrearSubRubroUseCase(iSubRubroRepository);
        Assertions.assertThrows(SubRubroExisteException.class, () -> crearTipoSubRubroUseCase.crearSubRubro(SubRubroNueva));
    }
}
