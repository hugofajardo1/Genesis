package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.Rubro;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.ObtenerRubrosRepoImplmentacion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:obtenerRubrosAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:obtenerRubrosDespues.sql")
})
public class RubroObtenerDataTest {
    @Inject
    ObtenerRubrosRepoImplmentacion miObtenerRubrosRepoImplmentacion;

    @Test
    public void obtenerRubros_RubrosExisten_DevuelveListado(){
        List<Rubro> rubros = miObtenerRubrosRepoImplmentacion.obtenerRubros();
        assertEquals(2, rubros.size());
    }
}
