package com.ar.genesis.sistema.fichaTest.controller;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import com.ar.genesis.sistema.localidad.core.domain.Localidad;
import com.ar.genesis.sistema.provincia.core.domain.Provincia;
import com.ar.genesis.sistema.tipoiva.core.domain.TipoIva;
import com.ar.genesis.sistema.ficha.core.exception.FichaNoExisteException;
import com.ar.genesis.sistema.ficha.core.input.IFichaObtenerPorIdInput;
import com.ar.genesis.sistema.ficha.service.controller.FichaObtenerPorIdController;
import com.ar.genesis.sistema.ficha.service.dto.FichaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@SpringBootTest
public class FichaObtenerPorIdControllerTest {
    @Mock
    IFichaObtenerPorIdInput miFichaObtenerPorIdInput;

    @Test
    public void obtenerFichaPorId_DevuelveFicha() throws FichaNoExisteException {
        Ficha unaFicha = Ficha.instancia(1, "Fajardo, Hugo", "Bs As 245", Localidad.instancia(1, "Chilecito"), Provincia.instancia(1, "La Rioja"), "3825416543", TipoIva.instancia(1, "Responsable Inscripto"), "20255071336", "B-00007-777", "Contacto: Fajardo");
        when(miFichaObtenerPorIdInput.obtenerFicha(1)).thenReturn(unaFicha);

        FichaObtenerPorIdController fichaObtenerPorIdController = new FichaObtenerPorIdController(miFichaObtenerPorIdInput);
        ResponseEntity<?> responseEntity = fichaObtenerPorIdController.obtenerFicha(1);
        FichaDTO resultado = (FichaDTO) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerFichaPorId_DevuelveNull() throws FichaNoExisteException {
        when(miFichaObtenerPorIdInput.obtenerFicha(1)).thenReturn(null);

        FichaObtenerPorIdController fichaObtenerPorIdController = new FichaObtenerPorIdController(miFichaObtenerPorIdInput);
        ResponseEntity<?> responseEntity = fichaObtenerPorIdController.obtenerFicha(1);
        FichaDTO resultado = (FichaDTO) responseEntity.getBody();
        Assertions.assertNull(resultado);
    }
}
