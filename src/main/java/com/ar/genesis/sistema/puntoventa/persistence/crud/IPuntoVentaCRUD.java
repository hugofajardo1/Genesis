package com.ar.genesis.sistema.puntoventa.persistence.crud;

import com.ar.genesis.sistema.puntoventa.core.domain.PuntoVenta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPuntoVentaCRUD extends CrudRepository<PuntoVenta, Integer> {

    boolean existsByNombre(String nombre);

    List<PuntoVenta> findAllByOrderById();

    PuntoVenta findPuntoVentaByIdEquals(Integer id);
}
