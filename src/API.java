import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class API {

    private final String API_KEY = "da7858b085452dec79fa7e4b";

    public double obtenerTasa(String from, String to) {
        URI direccion = URI.create(
                "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + from + "/" + to
        );

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Moneda tasa = new Gson().fromJson(response.body(), Moneda.class);
            return tasa.getConversionRate();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la tasa de cambio: " + e.getMessage());
        }
    }
}
