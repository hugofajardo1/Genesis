package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.Ubicacion;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.UbicacionObtenerRepoImplmentacion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:obtenerUbicacionesAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:obtenerUbicacionesDespues.sql")
})
public class UbicacionObtenerDataTest {
    @Inject
    UbicacionObtenerRepoImplmentacion miUbicacionObtenerRepoImplmentacion;

    @Test
    public void obtenerUbicaciones_UbicacionesExisten_DevuelveListado(){
        List<Ubicacion> ubicaciones = miUbicacionObtenerRepoImplmentacion.obtenerUbicaciones();
        assertEquals(2, ubicaciones.size());
    }
}
