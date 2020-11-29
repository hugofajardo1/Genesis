package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.Localidad;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.ObtenerLocalidadesRepoImplmentacion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:obtenerLocalidadesAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:obtenerLocalidadesDespues.sql")
})
public class ObtenerLocalidadesDataTest {
    @Inject
    ObtenerLocalidadesRepoImplmentacion obtenerLocalidadesRepoImplmentacion;

    @Test
    public void obtenerLocalidades_LocalidadesExisten_DevuelveListado(){
        List<Localidad> localidades = obtenerLocalidadesRepoImplmentacion.obtenerLocalidades();
        assertEquals(2, localidades.size());
    }
}
