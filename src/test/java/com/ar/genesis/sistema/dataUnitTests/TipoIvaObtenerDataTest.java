package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.TipoIvaRepoImplmentacion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:TipoIvaObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:TipoIvaObtenerDespues.sql")
})
public class TipoIvaObtenerDataTest {
    @Inject
    TipoIvaRepoImplmentacion miTipoIvaObtenerRepoImplmentacion;

    @Test
    public void obtenerTipoIvas_TipoIvasExisten_DevuelveListado(){
        List<TipoIva> tipoIvas = miTipoIvaObtenerRepoImplmentacion.obtenerTipoIvas();
        assertEquals(2, tipoIvas.size());
    }
}
