package br.com.treno.dados

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence


object Banco {
//    fun obterConexao(): Connection? {
//        return try {
//            DriverManager.getConnection("jdbc:mysql://localhost:3306/alugames", "usuario", "senha")
//        } catch (e: SQLException) {
//            e.printStackTrace()
//            null
//        }
//    }

    fun getEntityManager(): EntityManager{
        val factory:EntityManagerFactory = Persistence.createEntityManagerFactory("alugames")
        return factory.createEntityManager()
    }
}