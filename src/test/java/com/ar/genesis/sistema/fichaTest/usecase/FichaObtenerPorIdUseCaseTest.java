package com.ar.genesis.sistema.fichaTest.usecase;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import com.ar.genesis.sistema.localidad.core.domain.Localidad;
import com.ar.genesis.sistema.provincia.core.domain.Provincia;
import com.ar.genesis.sistema.tipoiva.core.domain.TipoIva;
import com.ar.genesis.sistema.ficha.core.exception.FichaNoExisteException;
import com.ar.genesis.sistema.ficha.core.repository.IFichaObtenerPorIdRepository;
import com.ar.genesis.sistema.ficha.core.usecase.FichaObtenerPorIdUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class FichaObtenerPorIdUseCaseTest {
    @Mock
    IFichaObtenerPorIdRepository miFichaObtenerPorIdRepository;

    @Test
    public void obtenerFichaPorId_devuelveFicha() throws FichaNoExisteException {
        Ficha unaFicha = Ficha.instancia(1, "Fajardo, Hugo", "Bs As 245", Localidad.instancia(1, "Chilecito"), Provincia.instancia(1, "La Rioja"), "3825416543", TipoIva.instancia(1, "Responsable Inscripto"), "20255071336", "B-00007-777", "Contacto: Fajardo");

        when(miFichaObtenerPorIdRepository.obtenerFicha(1)).thenReturn(unaFicha);

        FichaObtenerPorIdUseCase fichaObtenerPorIdUseCase = new FichaObtenerPorIdUseCase(miFichaObtenerPorIdRepository);
        Ficha resultado = fichaObtenerPorIdUseCase.obtenerFicha(1);
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerFichaPorId_devuelveFichaNoExiste() {

        when(miFichaObtenerPorIdRepository.obtenerFicha(1)).thenReturn(null);

        FichaObtenerPorIdUseCase FichaObtenerPorIdUseCase = new FichaObtenerPorIdUseCase(miFichaObtenerPorIdRepository);
        Assertions.assertThrows(FichaNoExisteException.class, () -> FichaObtenerPorIdUseCase.obtenerFicha(1));
    }
}