package com.ar.genesis.sistema.tipooperacionTest.data;

import com.ar.genesis.sistema.tipooperacion.core.domain.TipoOperacion;
import com.ar.genesis.sistema.tipooperacion.persistence.implementation.TipoOperacionObtenerRepoImplementacion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:TipoOperacionObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:TipoOperacionObtenerDespues.sql")
})
public class TipoOperacionObtenerDataTest {
    @Inject
    TipoOperacionObtenerRepoImplementacion miTipoOperacionObtenerRepoImplementacion;

    @Test
    public void obtenerTipoOperaciones_TipoOperacionesExisten_DevuelveListado(){
        List<TipoOperacion> tipoOperaciones = miTipoOperacionObtenerRepoImplementacion.obtenerTipoOperaciones();
        assertEquals(2, tipoOperaciones.size());
    }
}
