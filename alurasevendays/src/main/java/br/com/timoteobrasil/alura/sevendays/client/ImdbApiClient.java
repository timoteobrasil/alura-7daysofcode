package br.com.timoteobrasil.alura.sevendays.client;

import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.lang.System.LoggerFinder;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ImdbApiClient {

    private static final Logger LOGGER = LoggerFinder.getLoggerFinder().getLogger(ImdbApiClient.class.getName(),
            ImdbApiClient.class.getModule());

    // TODO externalizar essa URI
    private static final String URI_IMDB_TOP_250 = "https://imdb-api.com/en/API/Top250Movies/{apiKey}";

    private String key;

    public ImdbApiClient(String key) {
        super();
        this.key = key;
    }

    public String getBody() throws IOException, InterruptedException {
        if (this.key != null) {
            LOGGER.log(Level.INFO, "Realizando conexão com chave fornecida pelo usuário.");
            URI uriComChave = URI.create(URI_IMDB_TOP_250.replace("{apiKey}", key));
            HttpRequest request = HttpRequest.newBuilder().uri(uriComChave).GET().build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
            LOGGER.log(Level.INFO, "Response Status Code: " + response.statusCode());
            return response.body();
        } else {
            return null;
        }
    }
}
