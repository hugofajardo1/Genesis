package com.ar.genesis.sistema.tipooperacionTest.data;

import com.ar.genesis.sistema.tipooperacion.core.domain.TipoOperacion;
import com.ar.genesis.sistema.tipooperacion.persistence.implementation.TipoOperacionRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:TipoOperacionCrearAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:TipoOperacionCrearDespues.sql")
})
public class TipoOperacionCrearDataTest {
    @Inject
    TipoOperacionRepoImplementacion miTipoOperacionRepoImplementacion;

    @Test
    public void guardarTipoOperacion_TipoOperacionGuardado_devuelveTrue() {
        TipoOperacion unTipoOperacion = TipoOperacion.instancia(null, "Ventas");
        boolean resultado = miTipoOperacionRepoImplementacion.guardarTipoOperacion(unTipoOperacion);
        Assertions.assertTrue(resultado);
    }

}
