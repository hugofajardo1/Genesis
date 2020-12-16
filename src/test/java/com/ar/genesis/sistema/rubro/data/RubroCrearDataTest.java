package com.ar.genesis.sistema.rubro.data;

import com.ar.genesis.sistema.rubro.core.domain.Rubro;
import com.ar.genesis.sistema.rubro.persistence.implementation.RubroRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:RubroCrearAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:RubroCrearDespues.sql")
})
public class RubroCrearDataTest {
    @Inject
    RubroRepoImplementacion miRubroRepoImplementacion;

    @Test
    public void guardarRubro_RubroGuardado_devuelveTrue() {
        Rubro unRubro = Rubro.instancia(null, "Rubro");
        boolean resultado = miRubroRepoImplementacion.guardarRubro(unRubro);
        Assertions.assertTrue(resultado);
    }

}
