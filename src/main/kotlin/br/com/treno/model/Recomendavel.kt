package br.com.treno.model

interface Recomendavel {
    val media: Double

    fun recomendar(nota: Int)
}