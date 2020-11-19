package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.Cliente;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.ObtenerClientesRepoImplementacion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:obtenerClientesAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:obtenerClientesDespues.sql")
})
public class ObtenerClientesDataUT {

    @Inject
    ObtenerClientesRepoImplementacion obtenerClientesRepoImplementacion;

    @Test
    public void obtenerClientes_ExistenClientes_DevuelveListado(){
        List<Cliente> clientes = obtenerClientesRepoImplementacion.obtenerClientes();
        assertEquals(2, clientes.size());
    }
}
