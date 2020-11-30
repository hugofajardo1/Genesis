package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.TipoFichaRepoImplmentacion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:obtenerTipoFichasAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:obtenerTipoFichasDespues.sql")
})
public class TipoFichaObtenerDataTest {
    @Inject
    TipoFichaRepoImplmentacion miTipoFichaObtenerRepoImplmentacion;

    @Test
    public void obtenerTipoFichas_TipoFichasExisten_DevuelveListado(){
        List<TipoFicha> tipoFichas = miTipoFichaObtenerRepoImplmentacion.obtenerTipoFichas();
        assertEquals(2, tipoFichas.size());
    }
}
