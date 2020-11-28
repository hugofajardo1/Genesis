package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.SubRubro;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.SubRubroRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:crearSubRubroAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:crearSubRubroDespues.sql")
})
public class CrearSubRubroDataTest {

    @Inject
    SubRubroRepoImplementacion SubRubroRepoImplementacion;

    @Test
    public void guardarSubRubro_SubRubroGuardado_devuelveTrue() {
        SubRubro unSubRubro = SubRubro.instancia(null, "SubRubro");
        boolean resultado = SubRubroRepoImplementacion.guardarSubRubro(unSubRubro);
        Assertions.assertTrue(resultado);
    }

}
