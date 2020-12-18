package com.ar.genesis.sistema.subrubroTest.data;

import com.ar.genesis.sistema.subrubro.core.domain.SubRubro;
import com.ar.genesis.sistema.subrubro.persistence.implementation.SubRubroObtenerRepoImplementacion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:SubRubroObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:SubRubroObtenerDespues.sql")
})
public class SubRubroObtenerDataTest {
    @Inject
    SubRubroObtenerRepoImplementacion miSubRubroObtenerRepoImplementacion;

    @Test
    public void obtenerSubRubros_SubRubrosExisten_DevuelveListado(){
        List<SubRubro> subRubros = miSubRubroObtenerRepoImplementacion.obtenerSubRubros();
        assertEquals(2, subRubros.size());
    }
}
