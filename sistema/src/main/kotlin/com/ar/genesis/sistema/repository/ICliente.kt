package com.ar.genesis.sistema.repository

import com.ar.genesis.sistema.domain.Cliente

interface ICliente{
    fun existeCliente(nombre: String) : Boolean

    fun guardarCliente(cliente: Cliente) : Boolean
}