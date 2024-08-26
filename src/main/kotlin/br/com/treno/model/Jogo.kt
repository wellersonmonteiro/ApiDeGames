package br.com.treno.model

import br.com.treno.utilitario.formatarValor
import com.google.gson.annotations.Expose


data class Jogo(
    @Expose var titulo: String,
    @Expose val capa: String,
) : Recomendavel {
    var descricao: String? = null
    var preco = 0.0

    var id = 0

    constructor(
        titulo: String,
        capa: String,
        preco: Double,
        descricao: String?,
        id: Int,
    ) : this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
    }
    constructor(
        titulo: String,
        capa: String,
        preco: Double,
        descricao: String?
    ) : this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
    }


    fun formatarValor(value: Double): String {
        val result = "%.2f".format(value)
        return result
    }

    private val listaNotas = mutableListOf<Int>()
    override val media: Double
        get() = listaNotas.average().formatarValor()

    override fun recomendar(nota: Int) {
        if (nota in 1..10) {
            listaNotas.add(nota)
        } else {
            throw IllegalArgumentException("Nota inválida")
        }
    }

    override fun toString(): String {
        return "Meu br.com.treno.model.Jogo :\n" +
                "Título:$titulo\n" +
                "Capa:$capa\n" +
                "Descricao:$descricao\n" +
                "Preço: ${preco.formatarValor()}\n" +
                "Reputação $media}"
    }


}