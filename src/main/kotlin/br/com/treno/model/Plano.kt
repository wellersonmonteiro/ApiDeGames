package br.com.treno.model

abstract class Plano(val tipo: String) {

   open fun obterValorAluguel(aluguel: Aluguel): Double{
        return aluguel.jogo.preco * aluguel.periodo.emDias
    }
}