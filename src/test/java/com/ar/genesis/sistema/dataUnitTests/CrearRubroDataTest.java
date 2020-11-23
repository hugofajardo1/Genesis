package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.Rubro;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.RubroRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:crearRubroAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:crearRubroDespues.sql")
})
public class CrearRubroDataTest {

    @Inject
    RubroRepoImplementacion rubroRepoImplementacion;

    @Test
    public void guardarRubro_RubroGuardado_devuelveTrue() {
        Rubro rubro = Rubro.instancia(null, "Rubro");
        boolean resultado = rubroRepoImplementacion.guardarRubro(rubro);
        Assertions.assertTrue(resultado);
    }

}
