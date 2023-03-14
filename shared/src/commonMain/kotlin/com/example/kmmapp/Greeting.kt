package com.example.kmmapp

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }

    fun testKotlinSerialization() : String {
        val data = Project("kotlinx.serialization", "Kotlin")
        return  Json.encodeToString(data)

    }

    private fun decodeObject() {
        val objectJson =  testKotlinSerialization()
        println(objectJson) // {"name":"kotlinx.serialization","language":"Kotlin"}
        // Deserializing back into objects
        val obj = Json.decodeFromString<Project>(objectJson)
        println(obj)


    }

    private val client = HttpClient()

    suspend fun greeting(): String {
        val response: HttpResponse = client.get("https://www.7timer.info/bin/astro.php?lon=113.2&lat=23.1&ac=0&unit=metric&output=json&tzshift=0")
        return response.body<String>().toString()
    }
}

@Serializable
data class Project(val name: String, val language: String)