package com.ar.genesis.sistema.provincia.data;

import com.ar.genesis.sistema.provincia.core.domain.Provincia;
import com.ar.genesis.sistema.provincia.persistence.implementation.ProvinciaRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ProvinciaCrearAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ProvinciaCrearDespues.sql")
})
public class ProvinciaCrearDataTest {
    @Inject
    ProvinciaRepoImplementacion miProvinciaRepoImplementacion;

    @Test
    public void guardarProvincia_ProvinciaGuardado_devuelveTrue() {
        Provincia unProvincia = Provincia.instancia(null, "Provincia");
        boolean resultado = miProvinciaRepoImplementacion.guardarProvincia(unProvincia);
        Assertions.assertTrue(resultado);
    }

}
