package br.com.treno.dados

import br.com.treno.model.Jogo
import javax.persistence.EntityManager

class JogosDAO(val manager: EntityManager) {
    fun getJogos(): List<Jogo> {
            val query = manager.createQuery("SELECT j FROM JogoEntity j", JogoEntity::class.java)
            return query.resultList.map { entity ->
                Jogo(
                    entity.titulo ?: "",
                    entity.capa ?: "",
                    entity.preco ?: 0.0,
                    entity.descricao ?: "",
                    entity.id ?: 0
                )
            }
        }


    fun adicionarJogo(jogo: Jogo) {
        val entity = JogoEntity(
            titulo = jogo.titulo,
            capa = jogo.capa,
            preco = jogo.preco,
            descricao = jogo.descricao
        )
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }

}