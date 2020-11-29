package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.Ficha;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.FichaObtenerRepoImplementacion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:obtenerFichasAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:obtenerFichasDespues.sql")
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
