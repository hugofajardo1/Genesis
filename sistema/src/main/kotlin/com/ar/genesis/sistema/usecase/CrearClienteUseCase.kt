package com.ar.genesis.sistema.usecase

import com.ar.genesis.sistema.domain.Cliente
import com.ar.genesis.sistema.input.ICrearClienteInput
import com.ar.genesis.sistema.repository.ICliente

class CrearClienteUseCase :ICrearClienteInput {

    var iCliente: ICliente = TODO()

    override fun crearCliente(cliente: Cliente): Boolean {
        var clienteCreado = false
        if (!iCliente.existeCliente(cliente.nombre)) {
            clienteCreado = iCliente.guardarCliente(cliente)
        }
        return clienteCreado
    }

}