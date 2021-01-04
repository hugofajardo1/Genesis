package com.ar.genesis.sistema.movimiento.persistence.crud;

import com.ar.genesis.sistema.movimiento.core.domain.Movimiento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IMovimientoCRUD extends CrudRepository<Movimiento, Integer> {

    List<Movimiento> findAllByOrderById();

    Movimiento findMovimientoByIdEquals(Integer id);

    List<Movimiento> findAllByFechaBetween(LocalDate fechaDesde, LocalDate fechaHasta);
}
