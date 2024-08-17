package br.com.treno.main

import br.com.treno.model.Periodo
import br.com.treno.servico.ConsumoApi
import java.time.LocalDate


fun main() {

    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
    val listaJogosJson = consumo.buscaJogosJson()

    val gamerCaroline = listaGamers.get(3)
    val jogoResidentVillage = listaJogosJson.get(10)
    val jogoSpider = listaJogosJson[13]
    val jogoTheLastOf = listaJogosJson[2]

//    println(gamerCaroline)
//    println(jogoResidentVillage)

    val periodo1 = Periodo(LocalDate.of(2012,8,3), LocalDate.now().plusDays(3))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(10 -1))


    gamerCaroline.alugaJogo(jogoResidentVillage, periodo1)
    gamerCaroline.alugaJogo(jogoSpider, periodo2)
    gamerCaroline.alugaJogo(jogoTheLastOf, periodo3)

    println(gamerCaroline.jogosAlugados)
    println("Jogos alugados por mês:")
    println(gamerCaroline.jogosAlugadosPorMes(LocalDate.of(2024,8,14)))

}