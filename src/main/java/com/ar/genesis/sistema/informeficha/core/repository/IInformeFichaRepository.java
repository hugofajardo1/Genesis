package com.ar.genesis.sistema.informeficha.core.repository;

import com.ar.genesis.sistema.ficha.core.exception.FichaNoExisteException;
import com.ar.genesis.sistema.informeficha.core.domain.InformeFicha;

import java.time.LocalDate;

public interface IInformeFichaRepository {
    InformeFicha obtenerInformeFicha(Integer id, LocalDate fechaHasta) throws FichaNoExisteException;
}
