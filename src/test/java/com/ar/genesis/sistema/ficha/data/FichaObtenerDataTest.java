package com.ar.genesis.sistema.ficha.data;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import com.ar.genesis.sistema.ficha.persistence.implementation.FichaObtenerRepoImplementacion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:FichaObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:FichaObtenerDespues.sql")
})
public class FichaObtenerDataTest {

    @Inject
    FichaObtenerRepoImplementacion miFichaObtenerRepoImplementacion;

    @Test
    public void obtenerFichas_ExistenFichas_DevuelveListado(){
        List<Ficha> fichas = miFichaObtenerRepoImplementacion.obtenerFichas();
        assertEquals(2, fichas.size());
    }
}
