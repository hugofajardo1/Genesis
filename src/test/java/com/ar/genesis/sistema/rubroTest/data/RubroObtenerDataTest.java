package com.ar.genesis.sistema.rubroTest.data;

import com.ar.genesis.sistema.rubro.core.domain.Rubro;
import com.ar.genesis.sistema.rubro.persistence.implementation.RubroObtenerRepoImplementacion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:RubroObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:RubroObtenerDespues.sql")
})
public class RubroObtenerDataTest {
    @Inject
    RubroObtenerRepoImplementacion miRubroObtenerRepoImplementacion;

    @Test
    public void obtenerRubros_RubrosExisten_DevuelveListado(){
        List<Rubro> rubros = miRubroObtenerRepoImplementacion.obtenerRubros();
        assertEquals(2, rubros.size());
    }
}
