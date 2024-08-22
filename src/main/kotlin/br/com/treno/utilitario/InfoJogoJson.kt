package br.com.treno.utilitario

import br.com.treno.model.InfoJogoJson
import br.com.treno.model.Jogo

fun InfoJogoJson.criarJogo(): Jogo{
    return Jogo(
       this.titulo,
        this.capa,
        this.preco,
        this.descricao
    )
}