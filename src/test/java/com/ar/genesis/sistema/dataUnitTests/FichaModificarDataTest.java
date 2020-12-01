package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.Ficha;
import com.ar.genesis.sistema.core.domain.Localidad;
import com.ar.genesis.sistema.core.domain.Provincia;
import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.FichaRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:FichaModificarAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:FichaModificarDespues.sql")
})
public class FichaModificarDataTest {
    @Inject
    FichaRepoImplementacion miFichaRepoImplementacion;

    @Test
    public void guardarFicha_FichaGuardado_devuelveTrue() {
        Ficha unaFicha = Ficha.instancia(1, "Fajardo, Hugo Manuel", "Bs As 245", Localidad.instancia(1, "Chilecito"), Provincia.instancia(1, "La Rioja"), "38525416543", TipoIva.instancia(1, "Responsable Inscripto"), "20255071336", "B-00007-777", "Contacto: Fajardo");
        boolean resultado= miFichaRepoImplementacion.guardarFicha(unaFicha);
        Assertions.assertTrue(resultado);
    }
}
