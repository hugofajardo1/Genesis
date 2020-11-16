package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.TipoFichaRepoImplementacion;
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
public class CrearTipoFichaDataUnitTest {

    @Inject
    TipoFichaRepoImplementacion tipoClienteRepoImplementacion;

    @Test
    public void guardarTipoCliente_TipoClienteGuardado_devuelveTrue() {
        TipoFicha tipoFicha = TipoFicha.instancia(null, "Cliente");
        boolean resultado = tipoClienteRepoImplementacion.guardarTipoCliente(tipoFicha);
        Assertions.assertTrue(resultado);
    }

}
