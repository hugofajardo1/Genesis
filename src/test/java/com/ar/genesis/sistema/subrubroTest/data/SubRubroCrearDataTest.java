package com.ar.genesis.sistema.subrubroTest.data;

import com.ar.genesis.sistema.subrubro.core.domain.SubRubro;
import com.ar.genesis.sistema.subrubro.persistence.implementation.SubRubroRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:SubRubroCrearAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:SubRubroCrearDespues.sql")
})
public class SubRubroCrearDataTest {
    @Inject
    SubRubroRepoImplementacion miSubRubroRepoImplementacion;

    @Test
    public void guardarSubRubro_SubRubroGuardado_devuelveTrue() {
        SubRubro unSubRubro = SubRubro.instancia(null, "SubRubro");
        boolean resultado = miSubRubroRepoImplementacion.guardarSubRubro(unSubRubro);
        Assertions.assertTrue(resultado);
    }

}
