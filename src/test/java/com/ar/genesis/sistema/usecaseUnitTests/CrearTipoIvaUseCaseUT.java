package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.core.exception.TipoIvaExisteException;
import com.ar.genesis.sistema.core.repository.ITipoIvaRepository;
import com.ar.genesis.sistema.core.usecase.CrearTipoIvaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class CrearTipoIvaUseCaseUT {
    @Mock
    ITipoIvaRepository iTipoIvaRepository;
    @Test
    void crearTipoCliente_TipoIvaNoExiste_GuardaCorrectamente() throws TipoIvaExisteException {
        TipoIva unTipoIva = TipoIva.instancia(1, "Responsable Inscripto");
        when(iTipoIvaRepository.existeTipoIva("Responsable Inscripto")).thenReturn(false);
        when(iTipoIvaRepository.guardarTipoIva(unTipoIva)).thenReturn(true);
        CrearTipoIvaUseCase crearTipoClienteUseCase = new CrearTipoIvaUseCase(iTipoIvaRepository);
        boolean resultado = crearTipoClienteUseCase.crearTipoIva(unTipoIva);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearTipoCliente_TipoIvaExiste_NoGuardaTipoCliente() {
        TipoIva unTipoIva = TipoIva.instancia(1, "Responsable Inscripto");
        when(iTipoIvaRepository.existeTipoIva("Responsable Inscripto")).thenReturn(true);
        when(iTipoIvaRepository.guardarTipoIva(unTipoIva)).thenReturn(false);
        CrearTipoIvaUseCase crearTipoClienteUseCase = new CrearTipoIvaUseCase(iTipoIvaRepository);
        Assertions.assertThrows(TipoIvaExisteException.class, () -> crearTipoClienteUseCase.crearTipoIva(unTipoIva));
    }
}
