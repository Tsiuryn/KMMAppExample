package com.example.kmmapp

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
//        println(string) // {"name":"kotlinx.serialization","language":"Kotlin"}
//        // Deserializing back into objects
//        val obj = Json.decodeFromString<Project>(string)
//        println(obj)
    }
}

@Serializable
data class Project(val name: String, val language: String)