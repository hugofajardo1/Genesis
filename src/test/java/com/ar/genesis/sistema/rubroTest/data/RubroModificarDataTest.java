package com.ar.genesis.sistema.rubroTest.data;

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
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:RubroModificarAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:RubroModificarDespues.sql")
})
public class RubroModificarDataTest {
    @Inject
    RubroRepoImplementacion miRubroRepoImplementacion;

    @Test
    public void guardarRubro_RubroGuardado_devuelveTrue() {
        Rubro unRubro = Rubro.instancia(1, "Rubro 1");
        boolean resultado = miRubroRepoImplementacion.guardarRubro(unRubro);
        Assertions.assertTrue(resultado);
    }
}
