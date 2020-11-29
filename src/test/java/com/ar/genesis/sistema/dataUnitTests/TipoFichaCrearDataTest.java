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
public class TipoFichaCrearDataTest {

    @Inject
    TipoFichaRepoImplementacion miTipoFichaRepoImplementacion;

    @Test
    public void guardarTipoFicha_TipoFichaGuardado_devuelveTrue() {
        TipoFicha unTipoFicha = TipoFicha.instancia(null, "Cliente");
        boolean resultado = miTipoFichaRepoImplementacion.guardarTipoFicha(unTipoFicha);
        Assertions.assertTrue(resultado);
    }

}
