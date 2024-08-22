package br.com.treno.utilitario

fun Double.formatarValor(): Double {
    return String.format("%.2f", this).replace(",", ".").toDouble()
}