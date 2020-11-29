package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Provincia;
import com.ar.genesis.sistema.core.exception.ProvinciaExisteException;
import com.ar.genesis.sistema.core.repository.IProvinciaRepository;
import com.ar.genesis.sistema.core.usecase.ProvinciaCrearUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class ProvinciaCrearUseCaseTest {
    @Mock
    IProvinciaRepository miProvinciaRepository;
    @Test
    void crearTipoProvincia_ProvinciaNoExiste_GuardaCorrectamente() throws ProvinciaExisteException {
        Provincia unaProvincia = Provincia.instancia(1, "Provincia");
        when(miProvinciaRepository.existeProvincia("Provincia")).thenReturn(false);
        when(miProvinciaRepository.guardarProvincia(unaProvincia)).thenReturn(true);
        ProvinciaCrearUseCase provinciaCrearUseCase = new ProvinciaCrearUseCase(miProvinciaRepository);
        boolean resultado = provinciaCrearUseCase.crearProvincia(unaProvincia);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearTipoProvincia_ProvinciaExiste_NoGuardaTipoProvincia() {
        Provincia unaProvincia = Provincia.instancia(1, "Provincia");
        when(miProvinciaRepository.existeProvincia("Provincia")).thenReturn(true);
        when(miProvinciaRepository.guardarProvincia(unaProvincia)).thenReturn(false);
        ProvinciaCrearUseCase provinciaCrearUseCase = new ProvinciaCrearUseCase(miProvinciaRepository);
        Assertions.assertThrows(ProvinciaExisteException.class, () -> provinciaCrearUseCase.crearProvincia(unaProvincia));
    }
}
