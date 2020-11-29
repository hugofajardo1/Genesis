package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.ObtenerTipoIvasRepoImplmentacion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:obtenerTipoIvasAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:obtenerTipoIvasDespues.sql")
})
public class ObtenerTipoIvasDataTest {
    @Inject
    ObtenerTipoIvasRepoImplmentacion miObtenerTipoIvasRepoImplmentacion;

    @Test
    public void obtenerTipoIvas_TipoIvasExisten_DevuelveListado(){
        List<TipoIva> tipoIvas = miObtenerTipoIvasRepoImplmentacion.obtenerTipoIvas();
        assertEquals(2, tipoIvas.size());
    }
}
