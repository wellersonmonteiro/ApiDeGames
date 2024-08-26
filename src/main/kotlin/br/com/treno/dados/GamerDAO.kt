package br.com.treno.dados

import br.com.treno.model.Gamer
import javax.persistence.EntityManager

class GamersDAO(private val manager: EntityManager) {

    fun getGamers(): List<Gamer> {
        val query = manager.createQuery("FROM GamerEntity", GamerEntity::class.java)
        return query.resultList.map { entity -> Gamer(entity.nome, entity.email, entity.dataNascimento, entity.usuario, entity.id) }
    }

    fun adicionarGamer(gamer: Gamer) {
        val entity = GamerEntity(gamer.id, gamer.nome, gamer.email, gamer.dataNascimento, gamer.usuario)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }
}