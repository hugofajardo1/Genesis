package com.ar.genesis.sistema.informeficha.persistence.crud;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import com.ar.genesis.sistema.movimiento.core.domain.Movimiento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IInformeFichaCRUD extends CrudRepository<Movimiento, Integer> {

    List<Movimiento> findAllByFichaAndFechaBetween(Ficha unaFicha, LocalDate fechaDesde,  LocalDate fechaHasta);

    @Query(value = "SELECT SUM(montototal) AS DEBE FROM movimientos WHERE fichaid= ?1 AND fecha<= ?2 AND imputa='Debe'", nativeQuery = true)
    Double getSaldoDebe(Integer id, LocalDate fechaHasta);

    @Query(value = "SELECT SUM(montototal) AS HABER FROM movimientos WHERE fichaid= ?1 AND fecha<= ?2 AND imputa='Haber'", nativeQuery = true)
    Double getSaldoHaber(Integer id, LocalDate fechaHasta);

}
