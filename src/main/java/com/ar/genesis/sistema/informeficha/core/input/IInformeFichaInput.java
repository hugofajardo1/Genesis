package com.ar.genesis.sistema.informeficha.core.input;

import com.ar.genesis.sistema.ficha.core.exception.FichaNoExisteException;
import com.ar.genesis.sistema.informeficha.core.domain.InformeFicha;

import java.time.LocalDate;

public interface IInformeFichaInput {
    InformeFicha obtenerInformeFicha(Integer id, LocalDate fechaHasta) throws FichaNoExisteException;
}
