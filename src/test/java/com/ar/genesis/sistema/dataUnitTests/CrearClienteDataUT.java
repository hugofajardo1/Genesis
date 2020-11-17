package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.Cliente;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.ClienteRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:crearClienteAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:crearClienteDespues.sql")
})
public class CrearClienteDataUT {

    @Inject
    ClienteRepoImplementacion clienteRepoImplementacion;

    @Test
    public void guardarCliente_ClienteGuardado_devuelveTrue() {
        Cliente elCliente= Cliente.instancia(null, "Fajardo, Hugo Manuel", "Bs As 245", "38525416543");
        boolean resultado= clienteRepoImplementacion.guardarCliente(elCliente);
        Assertions.assertTrue(resultado);
    }

}
