package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Provincia;
import com.ar.genesis.sistema.core.exception.ProvinciaExisteException;
import com.ar.genesis.sistema.core.repository.IProvinciaRepository;
import com.ar.genesis.sistema.core.usecase.CrearProvinciaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class CrearProvinciaUseCaseTest {
    @Mock
    IProvinciaRepository miProvinciaRepository;
    @Test
    void crearTipoProvincia_ProvinciaNoExiste_GuardaCorrectamente() throws ProvinciaExisteException {
        Provincia unaProvincia = Provincia.instancia(1, "Provincia");
        when(miProvinciaRepository.existeProvincia("Provincia")).thenReturn(false);
        when(miProvinciaRepository.guardarProvincia(unaProvincia)).thenReturn(true);
        CrearProvinciaUseCase crearProvinciaUseCase = new CrearProvinciaUseCase(miProvinciaRepository);
        boolean resultado = crearProvinciaUseCase.crearProvincia(unaProvincia);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearTipoProvincia_ProvinciaExiste_NoGuardaTipoProvincia() {
        Provincia unaProvincia = Provincia.instancia(1, "Provincia");
        when(miProvinciaRepository.existeProvincia("Provincia")).thenReturn(true);
        when(miProvinciaRepository.guardarProvincia(unaProvincia)).thenReturn(false);
        CrearProvinciaUseCase crearProvinciaUseCase = new CrearProvinciaUseCase(miProvinciaRepository);
        Assertions.assertThrows(ProvinciaExisteException.class, () -> crearProvinciaUseCase.crearProvincia(unaProvincia));
    }
}
