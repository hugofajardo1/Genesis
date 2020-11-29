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
    ISubRubroRepository miSubRubroRepository;
    @Test
    void crearTipoSubRubro_SubRubroNoExiste_GuardaCorrectamente() throws SubRubroExisteException {
        SubRubro unSubRubro = SubRubro.instancia(1, "SubRubro");
        when(miSubRubroRepository.existeSubRubro("SubRubro")).thenReturn(false);
        when(miSubRubroRepository.guardarSubRubro(unSubRubro)).thenReturn(true);
        CrearSubRubroUseCase crearSubRubroUseCase = new CrearSubRubroUseCase(miSubRubroRepository);
        boolean resultado = crearSubRubroUseCase.crearSubRubro(unSubRubro);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearTipoSubRubro_SubRubroExiste_NoGuardaTipoSubRubro() {
        SubRubro unSubRubro = SubRubro.instancia(1, "SubRubro");
        when(miSubRubroRepository.existeSubRubro("SubRubro")).thenReturn(true);
        when(miSubRubroRepository.guardarSubRubro(unSubRubro)).thenReturn(false);
        CrearSubRubroUseCase crearSubRubroUseCase = new CrearSubRubroUseCase(miSubRubroRepository);
        Assertions.assertThrows(SubRubroExisteException.class, () -> crearSubRubroUseCase.crearSubRubro(unSubRubro));
    }
}
