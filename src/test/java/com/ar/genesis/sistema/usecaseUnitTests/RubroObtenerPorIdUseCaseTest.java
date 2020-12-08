package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Rubro;
import com.ar.genesis.sistema.core.exception.RubroNoExisteException;
import com.ar.genesis.sistema.core.repository.IRubroObtenerPorIdRepository;
import com.ar.genesis.sistema.core.usecase.RubroObtenerPorIdUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class RubroObtenerPorIdUseCaseTest {
    @Mock
    IRubroObtenerPorIdRepository miRubroObtenerPorIdRepository;

    @Test
    public void obtenerRubroPorId_devuelveRubro() throws RubroNoExisteException {
        Rubro unRubro = Rubro.instancia(1, "Rubro 1");

        when(miRubroObtenerPorIdRepository.obtenerRubro(1)).thenReturn(unRubro);

        RubroObtenerPorIdUseCase rubroObtenerPorIdUseCase = new RubroObtenerPorIdUseCase(miRubroObtenerPorIdRepository);
        Rubro resultado = rubroObtenerPorIdUseCase.obtenerRubro(1);
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerRubroPorId_devuelveRubroNoExiste() throws RubroNoExisteException {

        when(miRubroObtenerPorIdRepository.obtenerRubro(1)).thenReturn(null);

        RubroObtenerPorIdUseCase rubroObtenerPorIdUseCase = new RubroObtenerPorIdUseCase(miRubroObtenerPorIdRepository);
        Assertions.assertThrows(RubroNoExisteException.class, () -> rubroObtenerPorIdUseCase.obtenerRubro(1));
    }
}