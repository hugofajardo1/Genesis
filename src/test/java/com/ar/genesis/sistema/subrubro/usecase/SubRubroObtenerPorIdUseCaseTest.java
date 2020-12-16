package com.ar.genesis.sistema.subrubro.usecase;

import com.ar.genesis.sistema.subrubro.core.domain.SubRubro;
import com.ar.genesis.sistema.subrubro.core.exception.SubRubroNoExisteException;
import com.ar.genesis.sistema.subrubro.core.repository.ISubRubroObtenerPorIdRepository;
import com.ar.genesis.sistema.subrubro.core.usecase.SubRubroObtenerPorIdUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class SubRubroObtenerPorIdUseCaseTest {
    @Mock
    ISubRubroObtenerPorIdRepository miSubRubroObtenerPorIdRepository;

    @Test
    public void obtenerSubRubroPorId_devuelveSubRubro() throws SubRubroNoExisteException {
        SubRubro unSubRubro = SubRubro.instancia(1, "SubRubro 1");

        when(miSubRubroObtenerPorIdRepository.obtenerSubRubro(1)).thenReturn(unSubRubro);

        SubRubroObtenerPorIdUseCase subRubroObtenerPorIdUseCase = new SubRubroObtenerPorIdUseCase(miSubRubroObtenerPorIdRepository);
        SubRubro resultado = subRubroObtenerPorIdUseCase.obtenerSubRubro(1);
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerSubRubroPorId_devuelveSubRubroNoExiste() {

        when(miSubRubroObtenerPorIdRepository.obtenerSubRubro(1)).thenReturn(null);

        SubRubroObtenerPorIdUseCase subRubroObtenerPorIdUseCase = new SubRubroObtenerPorIdUseCase(miSubRubroObtenerPorIdRepository);
        Assertions.assertThrows(SubRubroNoExisteException.class, () -> subRubroObtenerPorIdUseCase.obtenerSubRubro(1));
    }
}