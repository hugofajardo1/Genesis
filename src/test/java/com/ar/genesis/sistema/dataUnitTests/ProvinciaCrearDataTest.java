package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.Provincia;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.ProvinciaRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:crearProvinciaAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:crearProvinciaDespues.sql")
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
