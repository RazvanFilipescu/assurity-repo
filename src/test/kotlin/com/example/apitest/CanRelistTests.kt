package com.example.apitest

import com.google.gson.GsonBuilder
import input.reader.HttpInputReader
import model.JsonInput
import org.json.JSONException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.springframework.boot.test.context.SpringBootTest
import utils.ReadInputUtils

@SpringBootTest
class CanRelistTests {

    companion object {
        private var jsonToMap: Map<String, Any> = HashMap()
        private lateinit var testModel: JsonInput
        private val readInputUtils: ReadInputUtils = ReadInputUtils()

        /**
         * BeforeAll function for getting the data from the API.
         * @return jsonToMap
         * @return testModel
         * The 2 data structures map the contents of the JSON in different ways, in order to showcase the possibilities.
         */
        @BeforeAll
        @JvmStatic
        fun `Read the JSON before any test`() {
            // Given
            val httpInputReader = HttpInputReader()
            val json = readInputUtils.readFromSource(httpInputReader)
            // Map JSON into HashMap and Data Class to showcase both possibilities
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

    /**
     * CanRelist test.
     * Compares the CanRelist attribute to an expected Boolean value, showcasing the Assertions.assertEquals functionality.
     * The input is parameterized in the CSV format, in order to allow the easy addition of other, similar test cases.
     */
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
}

