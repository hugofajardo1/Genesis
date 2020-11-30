package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.Provincia;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.ProvinciaProvinciaObtenerRepoImplmentacion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ProvinciaObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ProvinciaObtenerDespues.sql")
})
public class ProvinciaObtenerDataTest {
    @Inject
    ProvinciaProvinciaObtenerRepoImplmentacion miProvinciaObtenerRepoImplmentacion;

    @Test
    public void obtenerProvincias_ProvinciasExisten_DevuelveListado(){
        List<Provincia> Provincias = miProvinciaObtenerRepoImplmentacion.obtenerProvincias();
        assertEquals(2, Provincias.size());
    }
}
