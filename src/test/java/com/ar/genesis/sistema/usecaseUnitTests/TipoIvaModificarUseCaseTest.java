package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.core.exception.TipoIvaExisteException;
import com.ar.genesis.sistema.core.repository.ITipoIvaRepository;
import com.ar.genesis.sistema.core.usecase.TipoIvaUseCaseModificar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class TipoIvaModificarUseCaseTest {
    @Mock
    ITipoIvaRepository miTipoIvaRepository;
    @Test
    void modificarTipoIva_TipoIvaActualizadoCorrectamente() throws TipoIvaExisteException {
        TipoIva unTipoIva = TipoIva.instancia(1, "Responsable Inscripto");
        when(miTipoIvaRepository.existeTipoIva("Responsable Inscripto")).thenReturn(false);
        when(miTipoIvaRepository.guardarTipoIva(unTipoIva)).thenReturn(true);
        TipoIvaUseCaseModificar tipoIvaModificarUseCase = new TipoIvaUseCaseModificar(miTipoIvaRepository);
        boolean resultado = tipoIvaModificarUseCase.modificarTipoIva(unTipoIva);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarTipoIva_HayConflictoTipoIvaExiste_TipoIvaNoActualiza() {
        TipoIva unTipoIva = TipoIva.instancia(1, "Responsable Inscripto");
        when(miTipoIvaRepository.existeTipoIva("Responsable Inscripto")).thenReturn(true);
        when(miTipoIvaRepository.guardarTipoIva(unTipoIva)).thenReturn(false);
        TipoIvaUseCaseModificar tipoIvaModificarUseCase = new TipoIvaUseCaseModificar(miTipoIvaRepository);
        Assertions.assertThrows(TipoIvaExisteException.class, () -> tipoIvaModificarUseCase.modificarTipoIva(unTipoIva));
    }
}
