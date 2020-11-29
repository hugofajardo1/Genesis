package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.SubRubro;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.SubRubroObtenerRepoImplmentacion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:obtenerSubRubrosAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:obtenerSubRubrosDespues.sql")
})
public class SubRubroObtenerDataTest {
    @Inject
    SubRubroObtenerRepoImplmentacion miSubRubroObtenerRepoImplmentacion;

    @Test
    public void obtenerSubRubros_SubRubrosExisten_DevuelveListado(){
        List<SubRubro> subRubros = miSubRubroObtenerRepoImplmentacion.obtenerSubRubros();
        assertEquals(2, subRubros.size());
    }
}
