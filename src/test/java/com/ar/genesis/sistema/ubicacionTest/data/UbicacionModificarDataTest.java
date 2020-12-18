package com.ar.genesis.sistema.ubicacionTest.data;

import com.ar.genesis.sistema.ubicacion.core.domain.Ubicacion;
import com.ar.genesis.sistema.ubicacion.persistence.implementation.UbicacionRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:UbicacionModificarAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:UbicacionModificarDespues.sql")
})
public class UbicacionModificarDataTest {
    @Inject
    UbicacionRepoImplementacion miUbicacionRepoImplementacion;

    @Test
    public void guardarUbicacion_UbicacionGuardado_devuelveTrue() {
        Ubicacion unaUbicacion = Ubicacion.instancia(1, "Ubicacion 1");
        boolean resultado = miUbicacionRepoImplementacion.guardarUbicacion(unaUbicacion);
        Assertions.assertTrue(resultado);
    }
}
