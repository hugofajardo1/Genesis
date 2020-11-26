package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Cliente;
import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.core.input.IObtenerClientesInput;
import com.ar.genesis.sistema.service.controller.ObtenerClientesController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ObtenerClientesControllerTest {
    @Mock
    IObtenerClientesInput obtenerClientesInput;

    @Test
    public void obtenerClientes_ClientesExisten_Devuelve200(){
        List<Cliente> losClientes = new ArrayList<>();
        losClientes.add(Cliente.instancia(1,"Fajardo, Hugo", "Bs. As. 245", "3825416543", TipoIva.instancia(1, "Responsable Inscripto"), "20255071336"));
        when(obtenerClientesInput.obtenerClientes()).thenReturn(losClientes);

        ObtenerClientesController obtenerClientesController = new ObtenerClientesController(obtenerClientesInput);
        ResponseEntity<?> responseEntity = obtenerClientesController.obtenerClientes();
        List<?> resultado = (List<?>) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        if(resultado != null) {
            Assertions.assertEquals(resultado.size(), 1);
        }
    }
}
