package com.ar.genesis.sistema.fichaTest.data;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import com.ar.genesis.sistema.localidad.core.domain.Localidad;
import com.ar.genesis.sistema.provincia.core.domain.Provincia;
import com.ar.genesis.sistema.tipoiva.core.domain.TipoIva;
import com.ar.genesis.sistema.ficha.persistence.implementation.FichaRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:FichaCrearAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:FichaCrearDespues.sql")
})
public class FichaCrearDataTest {
    @Inject
    FichaRepoImplementacion miFichaRepoImplementacion;

    @Test
    public void guardarFicha_FichaGuardado_devuelveTrue() {
        Ficha unaFicha = Ficha.instancia(null, "Fajardo, Hugo Manuel", "Bs As 245", Localidad.instancia(1, "Chilecito"), Provincia.instancia(1, "La Rioja"), "38525416543", TipoIva.instancia(1, "Responsable Inscripto"), "20255071336", "B-00007-777", "Contacto: Fajardo");
        boolean resultado= miFichaRepoImplementacion.guardarFicha(unaFicha);
        Assertions.assertTrue(resultado);
    }

}
