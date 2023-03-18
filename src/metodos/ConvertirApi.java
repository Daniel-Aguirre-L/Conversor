package metodos;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConvertirApi {

    public static String Api(String monedaInicial, String monedaDestino, double valorMoneda)
            throws Exception {

        String url = "https://api.getgeoapi.com/v2/currency/convert" +
                "?api_key=40066d1895c12dfe77c017f6e010f585e5a4bfcf&from=" + monedaInicial +
                "&to=" + monedaDestino + "&amount=" + valorMoneda;


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> respuesta = client.send(request, HttpResponse.BodyHandlers.ofString());

        String responseBody = respuesta.body();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responseBody);
        JsonNode ratesNode = jsonNode.get("rates");
        JsonNode targetCurrencyNode = ratesNode.get(monedaDestino);
        String rateForAmount = targetCurrencyNode.get("rate_for_amount").asText();

        return (rateForAmount);

    }
}



