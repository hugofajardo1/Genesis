package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.Ubicacion;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.UbicacionRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:modificarUbicacionAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:modificarUbicacionDespues.sql")
})
public class ModificarUbicacionDataTest {
    @Inject
    UbicacionRepoImplementacion UbicacionRepoImplementacion;

    @Test
    public void guardarUbicacion_UbicacionGuardado_devuelveTrue() {
        Ubicacion unaUbicacion = Ubicacion.instancia(1, "Ubicacion 1");
        boolean resultado = UbicacionRepoImplementacion.guardarUbicacion(unaUbicacion);
        Assertions.assertTrue(resultado);
    }

}
