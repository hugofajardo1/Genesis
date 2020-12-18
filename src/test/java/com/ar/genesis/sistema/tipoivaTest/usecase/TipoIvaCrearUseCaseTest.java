package com.ar.genesis.sistema.tipoivaTest.usecase;

import com.ar.genesis.sistema.tipoiva.core.domain.TipoIva;
import com.ar.genesis.sistema.tipoiva.core.exception.TipoIvaExisteException;
import com.ar.genesis.sistema.tipoiva.core.repository.ITipoIvaRepository;
import com.ar.genesis.sistema.tipoiva.core.usecase.TipoIvaCrearUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class TipoIvaCrearUseCaseTest {
    @Mock
    ITipoIvaRepository miTipoIvaRepository;
    @Test
    void crearTipoIva_TipoIvaNoExiste_GuardaCorrectamente() throws TipoIvaExisteException {
        TipoIva unTipoIva = TipoIva.instancia(1, "Responsable Inscripto");
        when(miTipoIvaRepository.existeTipoIva("Responsable Inscripto")).thenReturn(false);
        when(miTipoIvaRepository.guardarTipoIva(unTipoIva)).thenReturn(true);
        TipoIvaCrearUseCase tipoIvaCrearUseCase = new TipoIvaCrearUseCase(miTipoIvaRepository);
        boolean resultado = tipoIvaCrearUseCase.crearTipoIva(unTipoIva);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearTipoIva_TipoIvaExiste_NoGuardaTipoIva() {
        TipoIva unTipoIva = TipoIva.instancia(1, "Responsable Inscripto");
        when(miTipoIvaRepository.existeTipoIva("Responsable Inscripto")).thenReturn(true);
        when(miTipoIvaRepository.guardarTipoIva(unTipoIva)).thenReturn(false);
        TipoIvaCrearUseCase tipoIvaCrearUseCase = new TipoIvaCrearUseCase(miTipoIvaRepository);
        Assertions.assertThrows(TipoIvaExisteException.class, () -> tipoIvaCrearUseCase.crearTipoIva(unTipoIva));
    }
}
