package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.Cliente;
import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.ClienteRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:modificarClienteAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:modificarClienteDespues.sql")
})
public class ModificarClienteDataTest {
    @Inject
    ClienteRepoImplementacion clienteRepoImplementacion;

    @Test
    public void guardarCliente_ClienteGuardado_devuelveTrue() {
        Cliente elCliente= Cliente.instancia(1, "Fajardo, Hugo Manuel", "Bs As 245", "38525416543", TipoIva.instancia(1, "Responsable Inscripto"), "20255071336");
        boolean resultado= clienteRepoImplementacion.guardarCliente(elCliente);
        Assertions.assertTrue(resultado);
    }
}
