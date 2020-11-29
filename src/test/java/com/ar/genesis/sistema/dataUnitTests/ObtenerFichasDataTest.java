package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.Ficha;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.ObtenerFichasRepoImplementacion;
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
public class ObtenerFichasDataTest {

    @Inject
    ObtenerFichasRepoImplementacion miObtenerFichasRepoImplementacion;

    @Test
    public void obtenerFichas_ExistenFichas_DevuelveListado(){
        List<Ficha> fichas = miObtenerFichasRepoImplementacion.obtenerFichas();
        assertEquals(2, fichas.size());
    }
}
