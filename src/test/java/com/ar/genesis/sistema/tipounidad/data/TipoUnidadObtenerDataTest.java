package com.ar.genesis.sistema.tipounidad.data;

import com.ar.genesis.sistema.tipounidad.core.domain.TipoUnidad;
import com.ar.genesis.sistema.tipounidad.persistence.implementation.TipoUnidadObtenerRepoImplementacion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:TipoUnidadObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:TipoUnidadObtenerDespues.sql")
})
public class TipoUnidadObtenerDataTest {
    @Inject
    TipoUnidadObtenerRepoImplementacion miTipoUnidadObtenerRepoImplementacion;

    @Test
    public void obtenerTipoUnidades_TipoUnidadesExisten_DevuelveListado(){
        List<TipoUnidad> tipoUnidades = miTipoUnidadObtenerRepoImplementacion.obtenerTipoUnidades();
        assertEquals(2, tipoUnidades.size());
    }
}
