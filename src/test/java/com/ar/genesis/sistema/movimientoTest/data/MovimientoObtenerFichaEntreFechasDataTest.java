package com.ar.genesis.sistema.movimientoTest.data;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import com.ar.genesis.sistema.localidad.core.domain.Localidad;
import com.ar.genesis.sistema.movimiento.persistence.implementation.MovimientoObtenerFichaEntreFechasRepoImplementacion;
import com.ar.genesis.sistema.provincia.core.domain.Provincia;
import com.ar.genesis.sistema.tipoiva.core.domain.TipoIva;
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
public class MovimientoObtenerFichaEntreFechasDataTest {
    @Inject
    MovimientoObtenerFichaEntreFechasRepoImplementacion miMovimientoObtenerClienteEntreFechasRepoImplementacion;

    @Test
    public void obtenerMovimientoFichaEntreFechas_DevuelveMovimiento() {
        Ficha unaFicha = Ficha.instancia(1, "Fajardo, Hugo", "Bs As 245", Localidad.instancia(1, "Chilecito"), Provincia.instancia(1, "La Rioja"), "3825416543", TipoIva.instancia(1, "Responsable Inscripto"), "20255071336", "B-00007-777", "Contacto: Fajardo");
        Assertions.assertEquals(miMovimientoObtenerClienteEntreFechasRepoImplementacion.obtenerMovimientosFichaEntreFechas(unaFicha, LocalDate.of(2020,12,1), LocalDate.of(2020,12,31)).size(), 1);
    }

    @Test
    public void obtenerMovimientoFichaEntreFechas_DevuelveNull() {
        Ficha unaFicha = Ficha.instancia(3, "Otro, Cliente", "Bs As 245", Localidad.instancia(1, "Chilecito"), Provincia.instancia(1, "La Rioja"), "3825416543", TipoIva.instancia(1, "Responsable Inscripto"), "20255071337", "B-00007-777", "Contacto: Fajardo");
        Assertions.assertEquals(miMovimientoObtenerClienteEntreFechasRepoImplementacion.obtenerMovimientosFichaEntreFechas(unaFicha, LocalDate.of(2020,11,1), LocalDate.of(2020,11,30)).size(),0) ;
    }
}