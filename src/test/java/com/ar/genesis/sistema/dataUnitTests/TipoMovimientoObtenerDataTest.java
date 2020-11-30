package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.TipoMovimientoRepoImplmentacion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:obtenerTipoMovimientosAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:obtenerTipoMovimientosDespues.sql")
})
public class TipoMovimientoObtenerDataTest {
    @Inject
    TipoMovimientoRepoImplmentacion miTipoMovimientoObtenerRepoImplmentacion;

    @Test
    public void obtenerTipoMovimientos_TipoMovimientosExisten_DevuelveListado(){
        List<TipoMovimiento> tipoMovimientos = miTipoMovimientoObtenerRepoImplmentacion.obtenerTipoMovimientos();
        assertEquals(2, tipoMovimientos.size());
    }
}
