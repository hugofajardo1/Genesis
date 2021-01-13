package com.ar.genesis.sistema.informeficha.persistence.implementation;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import com.ar.genesis.sistema.ficha.core.exception.FichaNoExisteException;
import com.ar.genesis.sistema.ficha.persistence.crud.IFichaCRUD;
import com.ar.genesis.sistema.informeficha.core.domain.InformeFicha;
import com.ar.genesis.sistema.informeficha.core.repository.IInformeFichaRepository;
import com.ar.genesis.sistema.informeficha.persistence.crud.IInformeFichaCRUD;
import com.ar.genesis.sistema.movimiento.core.domain.Movimiento;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;

@Service
public class InformeFichaRepoImplementacion implements IInformeFichaRepository {
    @Inject
    IInformeFichaCRUD miInformeFichaCRUD;

    @Inject
    IFichaCRUD miFichaCRUD;

    @Override
    public InformeFicha obtenerInformeFicha(Integer id, LocalDate fechaHasta) throws FichaNoExisteException {
        Ficha unaFicha = miFichaCRUD.findFichaByIdEquals(id);
        if (unaFicha == null) {
            throw new FichaNoExisteException();
        }
        List<Movimiento> movimientos = miInformeFichaCRUD.findAllByFichaAndFechaLessThanEqual(unaFicha, fechaHasta);
        return InformeFicha.instancia(unaFicha, fechaHasta, 0.0, miInformeFichaCRUD.getSaldoDebe(unaFicha.getId(), fechaHasta), movimientos);
    }
}
