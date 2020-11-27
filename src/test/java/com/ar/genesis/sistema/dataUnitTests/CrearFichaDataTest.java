package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.Ficha;
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
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:crearFichaAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:crearFichaDespues.sql")
})
public class CrearFichaDataTest {

    @Inject
    FichaRepoImplementacion FichaRepoImplementacion;

    @Test
    public void guardarFicha_FichaGuardado_devuelveTrue() {
        Ficha ficha = Ficha.instancia(null, "Fajardo, Hugo Manuel", "Bs As 245", "38525416543", TipoIva.instancia(1, "Responsable Inscripto"), "20255071336");
        boolean resultado= FichaRepoImplementacion.guardarFicha(ficha);
        Assertions.assertTrue(resultado);
    }

}
