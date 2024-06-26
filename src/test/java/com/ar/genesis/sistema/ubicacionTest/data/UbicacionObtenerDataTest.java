package com.ar.genesis.sistema.ubicacionTest.data;

import com.ar.genesis.sistema.ubicacion.core.domain.Ubicacion;
import com.ar.genesis.sistema.ubicacion.persistence.implementation.UbicacionObtenerRepoImplementacion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:UbicacionObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:UbicacionObtenerDespues.sql")
})
public class UbicacionObtenerDataTest {
    @Inject
    UbicacionObtenerRepoImplementacion miUbicacionObtenerRepoImplementacion;

    @Test
    public void obtenerUbicaciones_UbicacionesExisten_DevuelveListado(){
        List<Ubicacion> ubicaciones = miUbicacionObtenerRepoImplementacion.obtenerUbicaciones();
        assertEquals(2, ubicaciones.size());
    }
}
