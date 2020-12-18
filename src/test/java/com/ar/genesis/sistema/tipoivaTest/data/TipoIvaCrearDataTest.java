package com.ar.genesis.sistema.tipoivaTest.data;

import com.ar.genesis.sistema.tipoiva.core.domain.TipoIva;
import com.ar.genesis.sistema.tipoiva.persistence.implementation.TipoIvaRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:TipoIvaCrearAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:TipoIvaCrearDespues.sql")
})
public class TipoIvaCrearDataTest {
    @Inject
    TipoIvaRepoImplementacion miTipoIvaRepoImplementacion;

    @Test
    public void guardarTipoIva_TipoIvaGuardado_devuelveTrue() {
        TipoIva unTipoIva = TipoIva.instancia(null, "Responsable Inscripto");
        boolean resultado = miTipoIvaRepoImplementacion.guardarTipoIva(unTipoIva);
        Assertions.assertTrue(resultado);
    }

}
