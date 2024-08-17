package br.com.treno.model

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Scanner
import kotlin.random.Random

data class Gamer(
    var nome: String,
    var email: String,
) {
    var dataNascimento: String? = null
    var usuario: String? = null
        set(value) {
            field = value
            if (idInterno.isNullOrBlank()) {
                criarIdInterno()

            }
        }
    var idInterno: String? = null
        private set
    val jogosBuscados = mutableListOf<Jogo?>()
    val jogosAlugados = mutableListOf<Aluguel>()

    constructor(
        nome: String,
        email: String,
        dataNascimento: String,
        usuario: String,
    ) : this(nome, email) {
        this.dataNascimento = dataNascimento
        this.usuario = usuario
        criarIdInterno()
    }

    override fun toString(): String {
        return "Gamer(nome='$nome', email='$email', " +
                "dataNascimento=$dataNascimento, usuario=$usuario," +
                " idInterno=$idInterno)"
    }

    private fun criarIdInterno() {
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        idInterno = "$usuario#$tag"
    }

    private fun validarEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {
            return email
        } else {
            throw IllegalArgumentException("Email inválido")
        }
    }

    fun alugaJogo(jogo: Jogo, periodo: Periodo): Aluguel {
        val aluguel = Aluguel(this, jogo, periodo)
        jogosAlugados.add(aluguel)

        return aluguel
    }

    fun jogosAlugadosPorMes(data: LocalDate): List<Jogo> {
        return jogosAlugados.filter {
            it.periodo.dataInicial.monthValue == data.monthValue &&
                    it.periodo.dataInicial.year == data.year
        }.map { aluguel -> aluguel.jogo }
    }

    companion object {
        fun criarGamer(leitura: Scanner): Gamer {
            println("Boas-vindas ao Alura Games!")
            println("Digite seu nome:")
            val nome = leitura.nextLine()
            println("Digite seu email:")
            val email = leitura.nextLine()
            println("Deseja completar o seu cadastro com usuário e data de nascimento? (s/n)")
            val opcao = leitura.nextLine()

            if (opcao.equals("s", true)) {
                println("Digite seu usuário:")
                val usuario = leitura.nextLine()
                println("Digite sua data de nascimento:")
                val dataNascimento = leitura.nextLine()
                return Gamer(nome, email, dataNascimento, usuario)
            } else {
                return Gamer(nome, email)
            }
        }
    }


}