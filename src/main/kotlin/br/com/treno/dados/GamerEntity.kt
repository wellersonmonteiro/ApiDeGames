package br.com.treno.dados

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "gamers")
open class GamerEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,
    val nome: String = "Nome do Gamer",
    val email: String = "email@email.com",
    val dataNascimento:String? = null,
    val usuario:String? = null) {
}