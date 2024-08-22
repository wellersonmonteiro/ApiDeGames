package br.com.treno.model

import br.com.treno.utilitario.formatarValor

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo
) {
    val valorAluguel = gamer.plano.obterValorAluguel(this)
   override fun toString(): String {
        return "Aluguel do ${jogo.titulo} por ${gamer.nome}  pelo valor de R$ ${valorAluguel.formatarValor()}"
    }
}
