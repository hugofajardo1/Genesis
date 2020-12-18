package com.ar.genesis.sistema.puntoventaTest.data;

import com.ar.genesis.sistema.puntoventa.core.domain.PuntoVenta;
import com.ar.genesis.sistema.puntoventa.persistence.implementation.PuntoVentaObtenerRepoImplementacion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:PuntoVentaObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:PuntoVentaObtenerDespues.sql")
})
public class PuntoVentaObtenerDataTest {
    @Inject
    PuntoVentaObtenerRepoImplementacion miPuntoVentaObtenerRepoImplementacion;

    @Test
    public void obtenerPuntoVentas_PuntoVentasExisten_DevuelveListado(){
        List<PuntoVenta> puntoventas = miPuntoVentaObtenerRepoImplementacion.obtenerPuntoVentas();
        assertEquals(2, puntoventas.size());
    }
}
