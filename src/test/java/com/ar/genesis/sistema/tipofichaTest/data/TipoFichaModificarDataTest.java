package com.ar.genesis.sistema.tipofichaTest.data;

import com.ar.genesis.sistema.tipoficha.core.domain.TipoFicha;
import com.ar.genesis.sistema.tipoficha.persistence.implementation.TipoFichaRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:TipoFichaModificarAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:TipoFichaModificarDespues.sql")
})
public class TipoFichaModificarDataTest {
    @Inject
    TipoFichaRepoImplementacion miTipoFichaRepoImplementacion;

    @Test
    public void guardarTipoFicha_TipoFichaGuardado_devuelveTrue() {
        TipoFicha unTipoFicha = TipoFicha.instancia(1, "Cliente");
        boolean resultado = miTipoFichaRepoImplementacion.guardarTipoFicha(unTipoFicha);
        Assertions.assertTrue(resultado);
    }
}
