package br.com.treno.model

class PlanoAvulso(
    tipo:String): Plano(tipo) {

    override fun obterValorAluguel(aluguel: Aluguel): Double {
       var valorOriginal:Double = super.obterValorAluguel(aluguel)
       return if (aluguel.gamer.media.toDouble() >= 8.0){
          valorOriginal * 0.9
       }
        else{
            return valorOriginal
        }

    }
}
fun main(){

}