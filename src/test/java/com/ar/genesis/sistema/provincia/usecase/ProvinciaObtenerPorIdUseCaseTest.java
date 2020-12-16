package com.ar.genesis.sistema.provincia.usecase;

import com.ar.genesis.sistema.provincia.core.domain.Provincia;
import com.ar.genesis.sistema.provincia.core.exception.ProvinciaNoExisteException;
import com.ar.genesis.sistema.provincia.core.repository.IProvinciaObtenerPorIdRepository;
import com.ar.genesis.sistema.provincia.core.usecase.ProvinciaObtenerPorIdUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class ProvinciaObtenerPorIdUseCaseTest {
    @Mock
    IProvinciaObtenerPorIdRepository miProvinciaObtenerPorIdRepository;

    @Test
    public void obtenerProvinciaPorId_devuelveProvincia() throws ProvinciaNoExisteException {
        Provincia unaProvincia = Provincia.instancia(1, "Provincia 1");

        when(miProvinciaObtenerPorIdRepository.obtenerProvincia(1)).thenReturn(unaProvincia);

        ProvinciaObtenerPorIdUseCase provinciaObtenerPorIdUseCase = new ProvinciaObtenerPorIdUseCase(miProvinciaObtenerPorIdRepository);
        Provincia resultado = provinciaObtenerPorIdUseCase.obtenerProvincia(1);
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerProvinciaPorId_devuelveProvinciaNoExiste() {

        when(miProvinciaObtenerPorIdRepository.obtenerProvincia(1)).thenReturn(null);

        ProvinciaObtenerPorIdUseCase provinciaObtenerPorIdUseCase = new ProvinciaObtenerPorIdUseCase(miProvinciaObtenerPorIdRepository);
        Assertions.assertThrows(ProvinciaNoExisteException.class, () -> provinciaObtenerPorIdUseCase.obtenerProvincia(1));
    }
}