package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Provincia;
import com.ar.genesis.sistema.core.exception.ProvinciaExisteException;
import com.ar.genesis.sistema.core.repository.IProvinciaRepository;
import com.ar.genesis.sistema.core.usecase.ModificarProvinciaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class ModificarProvinciaUseCaseTest {
    @Mock
    IProvinciaRepository iProvinciaRepository;
    @Test
    void modificarProvincia_ProvinciaActualizadoCorrectamente() throws ProvinciaExisteException {
        Provincia unaProvincia = Provincia.instancia(1, "Provincia");
        when(iProvinciaRepository.existeProvincia("Provincia")).thenReturn(false);
        when(iProvinciaRepository.guardarProvincia(unaProvincia)).thenReturn(true);
        ModificarProvinciaUseCase modificarProvinciaUseCase = new ModificarProvinciaUseCase(iProvinciaRepository);
        boolean resultado = modificarProvinciaUseCase.modificarProvincia(unaProvincia);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarProvincia_HayConflictoProvinciaExiste_ProvinciaNoActualiza() {
        Provincia unaProvincia = Provincia.instancia(1, "Provincia");
        when(iProvinciaRepository.existeProvincia("Provincia")).thenReturn(true);
        when(iProvinciaRepository.guardarProvincia(unaProvincia)).thenReturn(false);
        ModificarProvinciaUseCase modificarProvinciaUseCase = new ModificarProvinciaUseCase(iProvinciaRepository);
        Assertions.assertThrows(ProvinciaExisteException.class, () -> modificarProvinciaUseCase.modificarProvincia(unaProvincia));
    }
}
