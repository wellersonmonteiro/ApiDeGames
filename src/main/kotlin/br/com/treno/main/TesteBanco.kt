package br.com.treno.main

import br.com.treno.dados.Banco
import br.com.treno.dados.GamersDAO
import br.com.treno.dados.JogosDAO
import br.com.treno.model.Gamer
import br.com.treno.model.Jogo

fun main() {
    val jogo = Jogo(
        "The Last of Us Part I",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554",
        5.99,
        "Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito."
    )
    val jogo2 = Jogo(
        "The Last of Us Part II",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554",
        5.99,
        "Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito."
    )
    val jogo3 = Jogo(
        "Star Wars",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554",
        5.99,
        "Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito."
    )
    val gamer1 = Gamer("Joã6666o",
        "joao@email.com",
        "12/12/1990",
        "joao123")
    val gamer2 = Gamer("Maria",
        "asd@asda.as",
        "12/12/1990",
        "maria123")
    val manager = Banco.getEntityManager()
    val gamerDAO = GamersDAO(manager)
    gamerDAO.adicionarGamer(gamer1)

    val jogoDAO = JogosDAO(manager)
    jogoDAO.adicionarJogo(jogo2)
    jogoDAO.adicionarJogo(jogo3)
    gamerDAO.adicionarGamer(gamer2)

    val listaJogos: List<Jogo> = jogoDAO.getJogos()
    println(listaJogos)
    val listaGamers: List<Gamer> = gamerDAO.getGamers()
    println(listaGamers)
    manager.close()

}