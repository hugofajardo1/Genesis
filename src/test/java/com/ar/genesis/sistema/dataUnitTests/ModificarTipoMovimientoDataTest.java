package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.TipoMovimientoRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:modificarTipoMovimientoAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:modificarTipoMovimientoDespues.sql")
})
public class ModificarTipoMovimientoDataTest {
    @Inject
    TipoMovimientoRepoImplementacion tipoMovimientoRepoImplementacion;

    @Test
    public void guardarTipoMovimiento_TipoMovimientoGuardado_devuelveTrue() {
        TipoMovimiento tipoMovimiento = TipoMovimiento.instancia(1, "Responsable Inscripto");
        boolean resultado = tipoMovimientoRepoImplementacion.guardarTipoMovimiento(tipoMovimiento);
        Assertions.assertTrue(resultado);
    }

}
