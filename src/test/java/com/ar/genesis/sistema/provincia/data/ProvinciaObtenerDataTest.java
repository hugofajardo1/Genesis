package com.ar.genesis.sistema.provincia.data;

import com.ar.genesis.sistema.provincia.core.domain.Provincia;
import com.ar.genesis.sistema.provincia.persistence.implementation.ProvinciaObtenerRepoImplementacion;
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
    ProvinciaObtenerRepoImplementacion miProvinciaObtenerRepoImplementacion;

    @Test
    public void obtenerProvincias_ProvinciasExisten_DevuelveListado(){
        List<Provincia> Provincias = miProvinciaObtenerRepoImplementacion.obtenerProvincias();
        assertEquals(2, Provincias.size());
    }
}
