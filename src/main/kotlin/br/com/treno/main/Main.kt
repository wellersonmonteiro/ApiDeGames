package br.com.treno.main

import br.com.treno.model.Gamer
import br.com.treno.model.Jogo
import br.com.treno.servico.ConsumoApi
import java.util.*


fun main() {

    var meuJogo: Jogo? = null
    val leitura = Scanner(System.`in`)
    val  gamer = Gamer.criarGamer(leitura)
    println("Cadastro realizado com sucesso!")
    println(gamer)

    do {

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

        println("Deseja inserir uma descrição para o jogo? (s/n)")
        val opcao = leitura.nextLine()

        if (opcao.equals("s", true)) {
            println("Digite a descrição do jogo:")
            var descricaoPersonalisada = leitura.nextLine()
            meuJogo?.descricao = descricaoPersonalisada
        } else {
            meuJogo?.descricao = meuJogo?.titulo
        }
        gamer.jogosBuscados.add(meuJogo)
       println("Deseja buscar outro jogo? (s/n)")
       val resposta = leitura.nextLine()
} while (resposta.equals("s", true))
    println("Jogos buscados:")
    println(gamer.jogosBuscados)
    println("Busca realizada com sucesso!")
    println("conta: ${gamer.nome}")
    println(meuJogo)
}
