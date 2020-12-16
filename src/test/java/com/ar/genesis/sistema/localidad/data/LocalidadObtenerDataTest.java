package com.ar.genesis.sistema.localidad.data;

import com.ar.genesis.sistema.localidad.core.domain.Localidad;
import com.ar.genesis.sistema.ficha.persistence.implementation.LocalidadObtenerRepoImplementacion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:LocalidadObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:LocalidadObtenerDespues.sql")
})
public class LocalidadObtenerDataTest {
    @Inject
    LocalidadObtenerRepoImplementacion miLocalidadObtenerRepoImplementacion;

    @Test
    public void obtenerLocalidades_LocalidadesExisten_DevuelveListado(){
        List<Localidad> localidades = miLocalidadObtenerRepoImplementacion.obtenerLocalidades();
        assertEquals(2, localidades.size());
    }
}
