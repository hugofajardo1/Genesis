package com.ar.genesis.sistema.movimientoTest.data;

import com.ar.genesis.sistema.movimiento.persistence.implementation.MovimientoObtenerEntreFechasRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;
import java.time.LocalDate;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:MovimientoObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:MovimientoObtenerDespues.sql")
})
public class MovimientoObtenerEntreFechasDataTest {
    @Inject
    MovimientoObtenerEntreFechasRepoImplementacion miMovimientoObtenerEntreFechasRepoImplementacion;

    @Test
    public void obtenerMovimientoEntreFechas_DevuelveMovimiento() {
        Assertions.assertEquals(miMovimientoObtenerEntreFechasRepoImplementacion.obtenerMovimientosEntreFechas(LocalDate.of(2020,12,1), LocalDate.of(2020,12,31)).size(), 1);
    }

    @Test
    public void obtenerMovimientoEntreFechas_DevuelveNull() {

        Assertions.assertEquals(miMovimientoObtenerEntreFechasRepoImplementacion.obtenerMovimientosEntreFechas(LocalDate.of(2020,11,1), LocalDate.of(2020,11,30)).size(),0) ;
    }
}