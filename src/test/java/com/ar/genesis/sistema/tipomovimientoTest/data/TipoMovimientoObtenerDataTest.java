package com.ar.genesis.sistema.tipomovimientoTest.data;

import com.ar.genesis.sistema.tipomovimiento.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.tipomovimiento.persistence.implementation.TipoMovimientoObtenerRepoImplementacion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:TipoMovimientoObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:TipoMovimientoObtenerDespues.sql")
})
public class TipoMovimientoObtenerDataTest {
    @Inject
    TipoMovimientoObtenerRepoImplementacion miTipoMovimientoObtenerRepoImplementacion;

    @Test
    public void obtenerTipoMovimientos_TipoMovimientosExisten_DevuelveListado(){
        List<TipoMovimiento> tipoMovimientos = miTipoMovimientoObtenerRepoImplementacion.obtenerTipoMovimientos();
        assertEquals(2, tipoMovimientos.size());
    }
}
