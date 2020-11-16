package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.TipoCliente;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.TipoClienteRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:crearTipoClienteAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:crearTipoClienteDespues.sql")
})
public class CrearTipoClienteDataUnitTest {

    @Inject
    TipoClienteRepoImplementacion tipoClienteRepoImplementacion;

    @Test
    public void guardarTipoCliente_TipoClienteGuardado_devuelveTrue() {
        TipoCliente tipoCliente = TipoCliente.instancia(null, "Cliente");
        boolean resultado = tipoClienteRepoImplementacion.guardarTipoCliente(tipoCliente);
        Assertions.assertTrue(resultado);
    }

}
