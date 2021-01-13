package com.ar.genesis.sistema.informeficha.persistence.crud;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import com.ar.genesis.sistema.informeficha.core.domain.InformeFicha;
import com.ar.genesis.sistema.movimiento.core.domain.Movimiento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IInformeFichaCRUD extends CrudRepository<Movimiento, Integer> {
    List<Movimiento> findAllByFichaAndFechaLessThanEqual(Ficha unaFicha, LocalDate fechaHasta);

    @Query(value = "SELECT SUM(montototal) AS DEBE FROM movimientos WHERE fichaid= ?1 AND fecha<= ?2", nativeQuery = true)
    Double getSaldoDebe(Integer id, LocalDate fechaHasta);

}
