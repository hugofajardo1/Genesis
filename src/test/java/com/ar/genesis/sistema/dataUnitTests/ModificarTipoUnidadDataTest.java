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
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:modificarTipoUnidadAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:modificarTipoUnidadDespues.sql")
})
public class ModificarTipoUnidadDataTest {
    @Inject
    TipoUnidadRepoImplementacion tipoUnidadRepoImplementacion;

    @Test
    public void guardarTipoUnidad_TipoUnidadGuardado_devuelveTrue() {
        TipoUnidad tipoUnidad = TipoUnidad.instancia(1, "Responsable Inscripto");
        boolean resultado = tipoUnidadRepoImplementacion.guardarTipoUnidad(tipoUnidad);
        Assertions.assertTrue(resultado);
    }

}
