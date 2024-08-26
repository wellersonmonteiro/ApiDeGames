package br.com.treno.main

import br.com.treno.utilitario.formatarValor

fun main() {

    val valores = mutableListOf<Double>(10.0, 20.0, 30.0, 40.0, 50.0)

    valores.takeIf { it.get(2) == 40.0 }?.let {
        println("O terceiro elemento  é 30")
    }?: println("O terceiro elemento não é 30")



}