package com.example.apitest

import com.google.gson.GsonBuilder
import junit.framework.TestCase.assertTrue
import model.JsonInput
import org.json.JSONException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.springframework.boot.test.context.SpringBootTest
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertSame

@SpringBootTest
class APITests() {

    companion object {
        var jsonToMap: Map<String, Any> = HashMap()
        lateinit var testModel: JsonInput

        @BeforeAll
        @JvmStatic
        fun `Read the JSON before any test`() {
            // Given
            // Get response from API
            val client = HttpClient.newBuilder().build()
            val request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false"))
                .build()
            // Process response into JSON
            val response = client.send(request, HttpResponse.BodyHandlers.ofString())
            val json = response.body().toString()
            // Map JSON into HashMap and Data Class to showcase both possibilities
            // Catch possible JSON conversion error
            try {
                val gson = GsonBuilder().create()
                // HashMap for easy use in simple situations
                jsonToMap = gson.fromJson(json, jsonToMap.javaClass)
                // DataClass for use in nested situations, can also replace the HashMap
                testModel = gson.fromJson(json, JsonInput::class.java)
            } catch (e: JSONException) {
                println("JSON conversion failed!")
            }
        }
    }

    @ParameterizedTest
    @CsvSource(
        "Name, Carbon credits"
    )
    fun `Test the Name attribute from JSON`(attribute: String, expected: String) {
        // Given - done in BeforeAll
        // When - not necessary as we perform no actions on the input
        // Then
        Assertions.assertTrue(jsonToMap[attribute].toString() == expected)
    }

    @ParameterizedTest
    @CsvSource(
        "CanRelist, true"
    )
    fun `Test the CanRelist attribute from JSON`(attribute: String, expected: String) {
        // Given - done in BeforeAll
        // When - not necessary as we perform no actions on the input
        // Then
        Assertions.assertEquals(jsonToMap[attribute], expected.toBoolean())
    }

    @ParameterizedTest
    @CsvSource(
        "Gallery, Good position in category"
    )
    fun `Test the Promotions - Gallery element description attribute from JSON`(
        gallery: String,
        expected: String
    ) {
        // Given - done in BeforeAll
        // When - not necessary as we perform no actions on the input
        // Then
        testModel.Promotions.find { promo -> promo.Name == gallery }?.Description?.let { Assertions.assertTrue(it.contains(expected)) }
    }
}

