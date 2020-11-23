package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.TipoFichaRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:crearTipoFichaAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:crearTipoFichaDespues.sql")
})
public class CrearTipoFichaDataTest {

    @Inject
    TipoFichaRepoImplementacion tipoFichaRepoImplementacion;

    @Test
    public void guardarTipoFicha_TipoFichaGuardado_devuelveTrue() {
        TipoFicha tipoFicha = TipoFicha.instancia(null, "Cliente");
        boolean resultado = tipoFichaRepoImplementacion.guardarTipoFicha(tipoFicha);
        Assertions.assertTrue(resultado);
    }

}
