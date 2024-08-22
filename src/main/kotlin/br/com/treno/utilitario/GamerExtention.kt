package br.com.treno.utilitario

import br.com.treno.model.Gamer
import br.com.treno.model.InfoGamerJson

fun InfoGamerJson.criarGamer():Gamer {
    return Gamer(
        this.nome,
        this.email,
        this.dataNascimento,
        this.usuario
    )
}