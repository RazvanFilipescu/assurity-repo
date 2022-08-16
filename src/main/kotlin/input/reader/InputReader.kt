package input.reader

/**
 * Interface for getting data from the API.
 */

interface InputReader {
    fun readInput(url: String): String
}