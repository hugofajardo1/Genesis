package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.ObtenerTipoFichasRepoImplmentacion;
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
public class ObtenerTipoFichasDataTest {
    @Inject
    ObtenerTipoFichasRepoImplmentacion obtenerTipoFichasRepoImplmentacion;

    @Test
    public void obtenerTipoFichas_TipoFichasExisten_DevuelveListado(){
        List<TipoFicha> tipoFichas = obtenerTipoFichasRepoImplmentacion.obtenerTipoFichas();
        assertEquals(2, tipoFichas.size());
    }
}
