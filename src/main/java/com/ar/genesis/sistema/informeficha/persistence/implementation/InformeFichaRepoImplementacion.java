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
    public InformeFicha obtenerInformeFicha(Integer id, LocalDate fechaDesde, LocalDate fechaHasta) throws FichaNoExisteException {
        Ficha unaFicha = miFichaCRUD.findFichaByIdEquals(id);
        if (unaFicha == null) {
            throw new FichaNoExisteException();
        }
        List<Movimiento> movimientos = miInformeFichaCRUD.findAllByFichaAndFechaBetween(unaFicha, fechaDesde, fechaHasta);

        Double saldoInicialDebe = miInformeFichaCRUD.getSaldoDebe(unaFicha.getId(), fechaDesde);
        Double saldoInicialHaber = miInformeFichaCRUD.getSaldoHaber(unaFicha.getId(), fechaDesde);
        Double saldoFinalDebe = miInformeFichaCRUD.getSaldoDebe(unaFicha.getId(), fechaHasta);
        Double saldoFinalHaber = miInformeFichaCRUD.getSaldoHaber(unaFicha.getId(), fechaHasta);
        if (saldoInicialDebe==null) {
            saldoInicialDebe=0.0;
        }
        if (saldoInicialHaber==null) {
            saldoInicialHaber=0.0;
        }
        if (saldoFinalDebe==null) {
            saldoFinalDebe=0.0;
        }
        if (saldoFinalHaber==null) {
            saldoFinalHaber=0.0;
        }
        return InformeFicha.instancia(unaFicha, fechaDesde, fechaHasta, saldoInicialDebe - saldoInicialHaber, saldoFinalDebe  - saldoFinalHaber, movimientos);
    }
}
