package br.com.timoteobrasil;

import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.LoggerFinder;
import java.lang.System.Logger.Level;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.text.MessageFormat;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.com.timoteobrasil.alura.sevendays.parser.Top250DataDetailParser;
import br.com.timoteobrasil.alura.sevendays.parser.Top250DataParser;

/**
 * Hello world!
 *
 */
public class App {

    private static final Logger LOGGER = LoggerFinder.getLoggerFinder().getLogger(App.class.getName(), App.class.getModule());

    //TODO externalizar essa URI
    private static final String URI_IMDB_TOP_250 = "https://imdb-api.com/en/API/Top250Movies/{apiKey}";
    public static void main( String[] args ) {
        // Dia 2: ainda fazendo tudo no mainzão
        try(Scanner in = new Scanner(System.in)) {

            Top250DataParser parser = new Top250DataParser();
            //pegando a chave da api pela CLI
            System.out.print("Chave da api: ");
            String chave = in.next().trim();
            if(chave != null) {
                URI uriComChave = URI.create(URI_IMDB_TOP_250.replace("{apiKey}", chave));
                HttpRequest request = HttpRequest.newBuilder().uri(uriComChave).GET().build();
                HttpResponse<String> response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
                LOGGER.log(Level.INFO, "Response Status Code: "+ response.statusCode());
                String jsonzao = response.body();
                List<String> items = parser.parseItemsToStringList(jsonzao);
                Top250DataDetailParser detailParser = new Top250DataDetailParser();

                List<String> titles = items.stream().map(item -> detailParser.parseSingleField(item, "title")).collect(Collectors.toList());
                List<String> urlImages = items.stream().map(item -> detailParser.parseSingleField(item, "image")).collect(Collectors.toList());
                List<String> ratings = items.stream().map(item -> detailParser.parseSingleField(item, "imDbRating")).collect(Collectors.toList());
                List<String> years = items.stream().map(item -> detailParser.parseSingleField(item, "year")).collect(Collectors.toList());

                for(var i = 0 ; i < items.size(); i++) {
                    String saida = MessageFormat.format("{4}) [{0}] {1} ({2}) [{3}]", ratings.get(i), titles.get(i), years.get(i), urlImages.get(i), i+1);
                    System.out.println(saida);
                }
            } else {
                LOGGER.log(Level.INFO, "Chave de api não foi digitada.");
            }
        } catch (IOException | InterruptedException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}
