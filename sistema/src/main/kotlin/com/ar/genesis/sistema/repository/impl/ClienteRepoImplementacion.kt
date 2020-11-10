package com.ar.genesis.sistema.repository.impl

import com.ar.genesis.sistema.domain.Cliente
import com.ar.genesis.sistema.repository.ICliente

class ClienteRepoImplementacion  (val repo : ClienteRepository) : ICliente
{

    override fun existeCliente(nombre: String): Boolean {
        var encontrado = false
        val clienteEncontrado : Cliente = repo.findByNombre(nombre)
        if (clienteEncontrado.nombre == nombre)
            encontrado = true
        return encontrado
    }

    override fun guardarCliente(cliente: Cliente): Boolean {
        repo.save(cliente)
        return true
    }

}