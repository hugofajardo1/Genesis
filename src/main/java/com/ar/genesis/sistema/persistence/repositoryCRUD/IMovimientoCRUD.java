package com.ar.genesis.sistema.persistence.repositoryCRUD;

import com.ar.genesis.sistema.core.domain.Movimiento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovimientoCRUD extends CrudRepository<Movimiento, Integer> {

    List<Movimiento> findAllByOrderById();

    Movimiento findMovimientoByIdEquals(Integer id);
}
