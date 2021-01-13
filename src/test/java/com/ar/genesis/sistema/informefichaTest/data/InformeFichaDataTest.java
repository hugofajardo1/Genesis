package com.ar.genesis.sistema.informefichaTest.data;

import com.ar.genesis.sistema.ficha.core.exception.FichaNoExisteException;
import com.ar.genesis.sistema.informeficha.persistence.implementation.InformeFichaRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;
import java.time.LocalDate;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:InformeFichaObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:InformeFichaObtenerDespues.sql")
})
public class InformeFichaDataTest {
    @Inject
    InformeFichaRepoImplementacion miInformeFichaRepoImplementacion;

    @Test
    public void obtenerFichaPorId_DevuelveFicha() throws FichaNoExisteException {
        LocalDate fechaHasta = LocalDate.of(2020,12,31);
        Assertions.assertNotNull(miInformeFichaRepoImplementacion.obtenerInformeFicha(1, fechaHasta));
    }

    @Test
    public void obtenerFichaPorId_DevuelveNull() throws FichaNoExisteException {
        LocalDate fechaHasta = LocalDate.of(2020,12,31);
        Assertions.assertThrows(FichaNoExisteException.class, () -> miInformeFichaRepoImplementacion.obtenerInformeFicha(3, fechaHasta));
    }
}
