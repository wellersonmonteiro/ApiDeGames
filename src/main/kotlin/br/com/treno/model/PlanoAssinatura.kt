package br.com.treno.model

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double,
    private val jogosIncluidos: Int,
    val percentualDescontoReputacao: Double
) : Plano(tipo) {
    override fun obterValorAluguel(aluguel: Aluguel): Double {

        val jogosAlugados = aluguel.gamer.jogosAlugadosPorMes(aluguel.periodo.dataInicial).size + 1
        return if (jogosAlugados <= jogosIncluidos) {
            0.0
        } else {
            val valorOriginal = super.obterValorAluguel(aluguel)
           return if(aluguel.gamer.media.toDouble() > 8.0){
               valorOriginal * (1 - percentualDescontoReputacao)
           }else {
               valorOriginal
           }

        }
    }
}