package com.ar.genesis.sistema.input

import com.ar.genesis.sistema.domain.Cliente

interface ICrearClienteInput {
    fun crearCliente(cliente: Cliente) : Boolean
}