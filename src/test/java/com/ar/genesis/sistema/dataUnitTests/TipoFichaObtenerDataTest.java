package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.TipoFichaObtenerRepoImplmentacion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:TipoFichaObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:TipoFichaObtenerDespues.sql")
})
public class TipoFichaObtenerDataTest {
    @Inject
    TipoFichaObtenerRepoImplmentacion miTipoFichaObtenerRepoImplmentacion;

    @Test
    public void obtenerTipoFichas_TipoFichasExisten_DevuelveListado(){
        List<TipoFicha> tipoFichas = miTipoFichaObtenerRepoImplmentacion.obtenerTipoFichas();
        assertEquals(2, tipoFichas.size());
    }
}
