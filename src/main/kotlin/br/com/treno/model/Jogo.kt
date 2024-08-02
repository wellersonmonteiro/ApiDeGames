package br.com.treno.model

data class Jogo(
    var titulo: String,
    val capa: String
) {
    var descricao:String? = null
    override fun toString(): String {
        return "Meu br.com.treno.model.Jogo :\n" +
                "Título:$titulo\n" +
                "Capa:$capa\n" +
                "Descricao:$descricao\n"
    }


}