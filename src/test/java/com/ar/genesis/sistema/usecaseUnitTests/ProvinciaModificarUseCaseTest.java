package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Provincia;
import com.ar.genesis.sistema.core.exception.ProvinciaExisteException;
import com.ar.genesis.sistema.core.repository.IProvinciaRepository;
import com.ar.genesis.sistema.core.usecase.ProvinciaModificarUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class ProvinciaModificarUseCaseTest {
    @Mock
    IProvinciaRepository miProvinciaRepository;
    @Test
    void modificarProvincia_ProvinciaActualizadoCorrectamente() throws ProvinciaExisteException {
        Provincia unaProvincia = Provincia.instancia(1, "Provincia");
        when(miProvinciaRepository.existeProvincia("Provincia")).thenReturn(false);
        when(miProvinciaRepository.guardarProvincia(unaProvincia)).thenReturn(true);
        ProvinciaModificarUseCase provinciaModificarUseCase = new ProvinciaModificarUseCase(miProvinciaRepository);
        boolean resultado = provinciaModificarUseCase.modificarProvincia(unaProvincia);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarProvincia_HayConflictoProvinciaExiste_ProvinciaNoActualiza() {
        Provincia unaProvincia = Provincia.instancia(1, "Provincia");
        when(miProvinciaRepository.existeProvincia("Provincia")).thenReturn(true);
        when(miProvinciaRepository.guardarProvincia(unaProvincia)).thenReturn(false);
        ProvinciaModificarUseCase provinciaModificarUseCase = new ProvinciaModificarUseCase(miProvinciaRepository);
        Assertions.assertThrows(ProvinciaExisteException.class, () -> provinciaModificarUseCase.modificarProvincia(unaProvincia));
    }
}
