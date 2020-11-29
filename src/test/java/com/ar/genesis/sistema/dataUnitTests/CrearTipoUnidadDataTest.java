package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.TipoUnidad;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.TipoUnidadRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:crearTipoUnidadAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:crearTipoUnidadDespues.sql")
})
public class CrearTipoUnidadDataTest {

    @Inject
    TipoUnidadRepoImplementacion miTipoUnidadRepoImplementacion;

    @Test
    public void guardarTipoUnidad_TipoUnidadGuardado_devuelveTrue() {
        TipoUnidad unTipoUnidad = TipoUnidad.instancia(null, "Responsable Inscripto");
        boolean resultado = miTipoUnidadRepoImplementacion.guardarTipoUnidad(unTipoUnidad);
        Assertions.assertTrue(resultado);
    }

}
