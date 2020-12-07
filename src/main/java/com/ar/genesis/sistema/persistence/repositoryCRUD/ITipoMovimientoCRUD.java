package com.ar.genesis.sistema.persistence.repositoryCRUD;

import com.ar.genesis.sistema.core.domain.TipoMovimiento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITipoMovimientoCRUD extends CrudRepository<TipoMovimiento, Integer> {

    boolean existsByNombre(String nombre);

    List<TipoMovimiento> findAllByOrderById();

    TipoMovimiento findTipoMovimientoByIdEquals(Integer id);
}
