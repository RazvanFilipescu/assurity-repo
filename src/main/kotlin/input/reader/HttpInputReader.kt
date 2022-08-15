package input.reader

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

@Component
class HttpInputReader(): InputReader {
    override fun readInput(url: String): String {
        // Get response from API
        val client = HttpClient.newBuilder().build()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build()
        // Process response into JSON
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        return response.body().toString()
    }
}