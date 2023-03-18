package metodos;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConvertirApi {

    public static void Api(String monedaInicial, String monedaDestino, double valorMoneda)
            throws Exception {

        String url = "https://api.getgeoapi.com/v2/currency/convert?" +
                "api_key=40066d1895c12dfe77c017f6e010f585e5a4bfcf&from=COP&to=USD&amount=5000";


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> respuesta = client.send(request, HttpResponse.BodyHandlers.ofString());


        System.out.println(respuesta.body());
    }
}



