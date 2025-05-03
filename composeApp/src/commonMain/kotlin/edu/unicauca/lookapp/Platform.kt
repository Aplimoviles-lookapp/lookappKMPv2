package edu.unicauca.lookapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform