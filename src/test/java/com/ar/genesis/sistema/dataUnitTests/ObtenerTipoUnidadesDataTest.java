package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.TipoUnidad;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.ObtenerTipoUnidadesRepoImplmentacion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:obtenerTipoUnidadesAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:obtenerTipoUnidadesDespues.sql")
})
public class ObtenerTipoUnidadesDataTest {
    @Inject
    ObtenerTipoUnidadesRepoImplmentacion miObtenerTipoUnidadesRepoImplmentacion;

    @Test
    public void obtenerTipoUnidades_TipoUnidadesExisten_DevuelveListado(){
        List<TipoUnidad> tipoUnidades = miObtenerTipoUnidadesRepoImplmentacion.obtenerTipoUnidades();
        assertEquals(2, tipoUnidades.size());
    }
}
