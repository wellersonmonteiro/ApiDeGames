package br.com.treno.main

import br.com.treno.model.Gamer

fun main() {
    val gamer1 = Gamer("Jacques", "jacque@email.com")
    println(gamer1)

    val gamer2 = Gamer("Jenio", "jeni@email.com", "01/01/2000", "jenio")
    println(gamer2)

    gamer1.let {
        it.dataNascimento = "18/09/2000"
        it.usuario = "jacqueskywalker"
        it.idInterno = "jacqueskywalker1234"
    }
    println(gamer1)


}