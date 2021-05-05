package httpClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class TesteHttp {
    public static void main(String[] args) throws Exception {
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.google.com.br/"))
                .timeout(Duration.ofSeconds(10)).GET().build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println();
        System.out.println(response.headers());
        System.out.println();
        System.out.println(response.body());
    }
}
