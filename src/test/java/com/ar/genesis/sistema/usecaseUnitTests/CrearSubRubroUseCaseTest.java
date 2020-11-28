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
        SubRubro unSubRubro = SubRubro.instancia(1, "SubRubro");
        when(iSubRubroRepository.existeSubRubro("SubRubro")).thenReturn(false);
        when(iSubRubroRepository.guardarSubRubro(unSubRubro)).thenReturn(true);
        CrearSubRubroUseCase crearSubRubroUseCase = new CrearSubRubroUseCase(iSubRubroRepository);
        boolean resultado = crearSubRubroUseCase.crearSubRubro(unSubRubro);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearTipoSubRubro_SubRubroExiste_NoGuardaTipoSubRubro() {
        SubRubro unSubRubro = SubRubro.instancia(1, "SubRubro");
        when(iSubRubroRepository.existeSubRubro("SubRubro")).thenReturn(true);
        when(iSubRubroRepository.guardarSubRubro(unSubRubro)).thenReturn(false);
        CrearSubRubroUseCase crearSubRubroUseCase = new CrearSubRubroUseCase(iSubRubroRepository);
        Assertions.assertThrows(SubRubroExisteException.class, () -> crearSubRubroUseCase.crearSubRubro(unSubRubro));
    }
}
