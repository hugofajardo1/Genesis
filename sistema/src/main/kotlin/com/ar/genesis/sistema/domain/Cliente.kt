package com.ar.genesis.sistema.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Cliente(
        @Id @GeneratedValue var id: Long,
        var nombre: String,
        var domicilio: String
)