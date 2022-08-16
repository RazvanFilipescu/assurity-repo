package utils

import input.reader.InputReader
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.stereotype.Component
import java.io.IOException
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths


const val CONFIGURATION_FILE_PATH = "src/main/resources/configuration.txt"

/**
 * Class for reading the url from a configuration file in order to access the data source.
 * The reading is done via the InputReader interface, which abstracts the connection to various types of data sources.
 */
@Component
class ReadInputUtils {
    val logger: Logger = LogManager.getLogger(ReadInputUtils::class.java)

    fun readFromSource(inputReader: InputReader): String? {
        val lines: List<String>
        try {
            lines = Files.readAllLines(Paths.get(CONFIGURATION_FILE_PATH), StandardCharsets.UTF_8)
        }  catch (ioe: IOException) {
            logger.error("File IOException: ${ioe.message}")
            throw IOException(ioe.message)
        }

        val keyValuePairs = lines.map { it.trim() }
            .filterNot { it.isEmpty() }
            .filterNot(::commentedOut)
            .map(::toKeyValuePair)
        val mapPairs = keyValuePairs.associate { Pair(it.first, it.second) }

        mapPairs["url"]?.let { return inputReader.readInput(it) } ?: run{
            logger.error("URL configuration not found.")
            throw Exception("URL configuration not found.")
        }
    }

    private fun commentedOut(line: String) = line.startsWith("#") || line.startsWith(";")

    private fun toKeyValuePair(line: String) = line.split(Regex(" "), 2).let {
        Pair(it[0], if (it.size == 1) "" else it[1])
    }
}