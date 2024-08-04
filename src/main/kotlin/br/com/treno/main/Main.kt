package br.com.treno.main

import br.com.treno.model.Jogo
import br.com.treno.servico.ConsumoApi
import java.util.*


fun main() {

    var meuJogo: Jogo? = null

    val leitura = Scanner(System.`in`)
    println("Digite um código de jogo para buscar:")
    val busca = leitura.nextLine()

    val buscaApi = ConsumoApi()
    val meuInfoJogo = buscaApi.buscarJogo(busca)

    val resultado = runCatching {
        meuJogo = Jogo(
            meuInfoJogo.info.title,
            meuInfoJogo.info.thumb
        )

    }

    resultado.onFailure {
        println("br.com.treno.model.Jogo não encontrado")
    }

    resultado.onSuccess {
        println("Deseja inserir uma descrição para o jogo? (s/n)")
        val opcao = leitura.nextLine()

        if (opcao.equals("s", true)) {
            println("Digite a descrição do jogo:")
            var descricaoPersonalisada = leitura.nextLine()
            meuJogo?.descricao  = descricaoPersonalisada
        } else{
            meuJogo?.descricao = meuJogo?.titulo
        }
    }

    println(meuJogo)
}
