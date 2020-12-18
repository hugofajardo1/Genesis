package com.ar.genesis.sistema.puntoventaTest.data;

import com.ar.genesis.sistema.puntoventa.core.domain.PuntoVenta;
import com.ar.genesis.sistema.puntoventa.persistence.implementation.PuntoVentaRepoImplementacion;
import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:PuntoVentaCrearAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:PuntoVentaCrearDespues.sql")
})
public class PuntoVentaCrearDataTest {
    @Inject
    PuntoVentaRepoImplementacion miPuntoVentaRepoImplementacion;

    @Test
    public void guardarPuntoVenta_PuntoVentaGuardado_devuelveTrue() {
        PuntoVenta unPuntoVenta = PuntoVenta.instancia(null, "PuntoVenta 1", Sucursal.instancia(1, "Sucursal 1"), 5);
        boolean resultado = miPuntoVentaRepoImplementacion.guardarPuntoVenta(unPuntoVenta);
        Assertions.assertTrue(resultado);
    }

}
