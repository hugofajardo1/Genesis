package com.ar.genesis.sistema.provinciaTest.usecase;

import com.ar.genesis.sistema.provincia.core.domain.Provincia;
import com.ar.genesis.sistema.provincia.core.exception.ProvinciaExisteException;
import com.ar.genesis.sistema.provincia.core.repository.IProvinciaRepository;
import com.ar.genesis.sistema.provincia.core.usecase.ProvinciaCrearUseCase;
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
    void crearProvincia_ProvinciaNoExiste_GuardaCorrectamente() throws ProvinciaExisteException {
        Provincia unaProvincia = Provincia.instancia(1, "Provincia");
        when(miProvinciaRepository.existeProvincia("Provincia")).thenReturn(false);
        when(miProvinciaRepository.guardarProvincia(unaProvincia)).thenReturn(true);
        ProvinciaCrearUseCase provinciaCrearUseCase = new ProvinciaCrearUseCase(miProvinciaRepository);
        boolean resultado = provinciaCrearUseCase.crearProvincia(unaProvincia);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearProvincia_ProvinciaExiste_NoGuardaProvincia() {
        Provincia unaProvincia = Provincia.instancia(1, "Provincia");
        when(miProvinciaRepository.existeProvincia("Provincia")).thenReturn(true);
        when(miProvinciaRepository.guardarProvincia(unaProvincia)).thenReturn(false);
        ProvinciaCrearUseCase provinciaCrearUseCase = new ProvinciaCrearUseCase(miProvinciaRepository);
        Assertions.assertThrows(ProvinciaExisteException.class, () -> provinciaCrearUseCase.crearProvincia(unaProvincia));
    }
}
