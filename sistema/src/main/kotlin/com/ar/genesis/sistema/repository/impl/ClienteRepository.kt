package com.ar.genesis.sistema.repository.impl

import com.ar.genesis.sistema.domain.Cliente
import org.springframework.data.repository.CrudRepository

interface ClienteRepository : CrudRepository<Cliente, Long> {

    fun findByNombre(nombre : String) : Cliente
}