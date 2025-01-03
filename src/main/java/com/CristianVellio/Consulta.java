package com.CristianVellio;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.github.cdimascio.dotenv.Dotenv;

public class Consulta {
    private String realizarConsultaAPI(String url) throws Exception {
        HttpClient cliente = HttpClient.newHttpClient();
        var peticion = java.net.http.HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build();
        HttpResponse<String> respuesta = cliente.send(peticion, HttpResponse.BodyHandlers.ofString());
        return respuesta.body();
    }

    public String buscaDivisa(String divisaBase, String divisaObjetivo, double monto) {
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("API_KEY");
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + divisaBase + "/" + divisaObjetivo + "/"
                + monto;
        try {
            String json = realizarConsultaAPI(url);
            JsonElement jElement = JsonParser.parseString(json);
            JsonObject jObject = jElement.getAsJsonObject();
            return jObject.get("conversion_result").getAsString();
        } catch (Exception e) {
            System.out.println("Error al realizar la conversión: " + e.getMessage());
            throw new RuntimeException("Error en la consulta API");
        }
    }
}
