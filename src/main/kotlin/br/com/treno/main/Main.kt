package br.com.treno.main

import br.com.treno.model.Periodo
import br.com.treno.model.PlanoAssinatura
import br.com.treno.servico.ConsumoApi
import com.google.gson.GsonBuilder
import java.io.File
import java.time.LocalDate


fun main() {

    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
    val listaJogoJson = consumo.buscaJogosJson()

//    val gamerCaroline = listaGamers.get(3)
//    val jogoResidentVillage = listaJogosJson.get(10)
//    val jogoSpider = listaJogosJson[13]
//    val jogoTheLastOf = listaJogosJson[2]

//    println(gamerCaroline)
//    println(jogoResidentVillage)

    val periodo1 = Periodo(LocalDate.of(2012,8,3), LocalDate.now().plusDays(3))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(10 -1))

//
//    gamerCaroline.alugaJogo(jogoResidentVillage, periodo1)
//    gamerCaroline.alugaJogo(jogoSpider, periodo2)
//    gamerCaroline.alugaJogo(jogoTheLastOf, periodo3)
//
//    println(gamerCaroline.jogosAlugados)
    println("Jogos alugados por mês:")
    //println(gamerCaroline.jogosAlugadosPorMes(LocalDate.of(2024,8,14)))

    val gamerCamila = listaGamers[5]
    gamerCamila.plano = PlanoAssinatura("PRATA", 9.90,3, 0.15)
    val gamerCaroline = listaGamers.get(3)
    val jogoResidentVillage = listaJogoJson.get(10)
    val jogoSpider = listaJogoJson.get(13)
    val jogoTheLastOfUs = listaJogoJson.get(2)
    val jogoDandara = listaJogoJson.get(5)
    val jogoAssassins = listaJogoJson.get(4)
    val jogoCyber = listaJogoJson.get(6)
    val jogoGod = listaJogoJson.get(7)
    val jogoSkyrim = listaJogoJson.get(18)

    gamerCamila.recomendarJogo(jogoResidentVillage, 7)
    gamerCamila.recomendarJogo(jogoTheLastOfUs, 10)
    gamerCamila.recomendarJogo(jogoAssassins, 8)
    gamerCamila.recomendarJogo(jogoCyber, 7)
    gamerCamila.recomendarJogo(jogoGod, 10)
    gamerCamila.recomendarJogo(jogoDandara, 8)
    gamerCamila.recomendarJogo(jogoSkyrim, 8)
    gamerCamila.recomendarJogo(jogoSpider, 6)
    gamerCamila.alugaJogo(jogoSpider, periodo2)
    gamerCamila.alugaJogo(jogoResidentVillage, periodo2)

    gamerCamila.alugaJogo(jogoGod, periodo3)
    gamerCamila.alugaJogo(jogoTheLastOfUs, periodo3)
//
//    println(gamerCamila.jogosAlugados)
//
//    gamerCamila.recomendar(7)
//    gamerCamila.recomendar(1)
//    gamerCamila.recomendar(8)
//
//    println(gamerCamila)
//
//    gamerCamila.alugaJogo(jogoResidentVillage, periodo2)
//    println(gamerCamila.jogosAlugados)
//
//    gamerCamila.recomendarJogo(jogoResidentVillage, 7)
//    gamerCamila.recomendarJogo(jogoTheLastOf, 10)
//
//    gamerCaroline.recomendarJogo(jogoResidentVillage, 8)
//    gamerCaroline.recomendarJogo(jogoTheLastOf, 9)
//
//    println("\nA média das notas de jogoResidentVillage será:")
//
//    println(jogoTheLastOf.media)
//    println("Os jogos recomendados da Caroline são:\n ${gamerCaroline.jogosRecomendados}")



    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()

    val serializar = gson.toJson(gamerCamila.jogosRecomendados)
    println(serializar)

    val arquivo = File("jogosRecomendados-${gamerCamila.nome}.json")
    arquivo.writeText(serializar)
    println(arquivo.absolutePath)

    println(gamerCamila.jogosAlugados)
}