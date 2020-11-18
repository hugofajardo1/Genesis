package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.TipoIvaRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:crearTipoIvaAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:crearTipoIvaDespues.sql")
})
public class CrearTipoIvaDataUT {

    @Inject
    TipoIvaRepoImplementacion tipoIvaRepoImplementacion;

    @Test
    public void guardarTipoIva_TipoIvaGuardado_devuelveTrue() {
        TipoIva tipoIva = TipoIva.instancia(null, "Responsable Inscripto");
        boolean resultado = tipoIvaRepoImplementacion.guardarTipoIva(tipoIva);
        Assertions.assertTrue(resultado);
    }

}
