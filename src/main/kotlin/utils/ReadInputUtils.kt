package utils

import input.reader.InputReader
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.io.FileNotFoundException
import java.io.IOException
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths

/**
 * Class for reading the url from a configuration file and using that url in order to access the data source.
 * The reading is done via the InputReader interface, which abstracts the connection to various types of data sources.
 */
@Component
class ReadInputUtils{
    fun readFromApi(inputReader: InputReader): String? {
        var lines: List<String>
        try {
            lines = Files.readAllLines(Paths.get("src/main/resources/configuration.txt"), StandardCharsets.UTF_8)
        } catch (ffe: FileNotFoundException) {
            println(ffe.message)
            return ""
        } catch (ioe: IOException) {
            println(ioe.message)
            return ""
        }

        val keyValuePairs = lines.map { it.trim() }
            .filterNot { it.isEmpty() }
            .filterNot(::commentedOut)
            .map(::toKeyValuePair)
        val mapPairs = keyValuePairs.associate { Pair(it.first,it.second) }

        mapPairs["url"]?.let{ return inputReader.readInput(it) } ?: return ""
    }

    private fun commentedOut(line: String) = line.startsWith("#") || line.startsWith(";")

    private fun toKeyValuePair(line: String) = line.split(Regex(" "), 2).let {
        Pair(it[0], if (it.size == 1) "" else it[1])
    }
}