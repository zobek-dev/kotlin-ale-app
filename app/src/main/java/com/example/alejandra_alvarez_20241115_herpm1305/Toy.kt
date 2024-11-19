package com.example.alejandra_alvarez_20241115_herpm1305

import java.io.Serializable

data class Toy(
    val name: String,       // Nombre del juguete
    val price: Int,         // Precio del juguete
    val imageRes: Int       // ID del recurso de la imagen del juguete
) : Serializable            // Implementamos Serializable para pasar objetos entre actividades
