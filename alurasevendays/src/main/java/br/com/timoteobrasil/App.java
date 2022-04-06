package br.com.timoteobrasil;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.lang.System.LoggerFinder;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.text.MessageFormat;
import java.util.Scanner;

import br.com.timoteobrasil.alura.sevendays.model.Top250Data;
import br.com.timoteobrasil.alura.sevendays.parser.Top250DataParser;
import br.com.timoteobrasil.alura.sevendays.view.HtmlGenerator;

/**
 * Hello world!
 *
 */
public class App {

    private static final Logger LOGGER = LoggerFinder.getLoggerFinder().getLogger(App.class.getName(), App.class.getModule());

    //TODO externalizar essa URI
    private static final String URI_IMDB_TOP_250 = "https://imdb-api.com/en/API/Top250Movies/{apiKey}";
    public static void main( String[] args ) {
        // Dia 4: ainda fazendo tudo no mainzão
        File tempFile = new File("list.html");
        try(Scanner in = new Scanner(System.in);
            PrintWriter fileWriter = new PrintWriter(tempFile)) {

            //pegando a chave da api pela CLI
            System.out.print("Chave da api: ");
            String chave = in.next().trim();
            if(chave != null) {
                URI uriComChave = URI.create(URI_IMDB_TOP_250.replace("{apiKey}", chave));
                HttpRequest request = HttpRequest.newBuilder().uri(uriComChave).GET().build();
                HttpResponse<String> response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
                LOGGER.log(Level.INFO, "Response Status Code: "+ response.statusCode());
                String jsonzao = response.body();
                
                Top250DataParser dataParser = new Top250DataParser();
                Top250Data data = dataParser.parse(jsonzao);

                HtmlGenerator generator = new HtmlGenerator(fileWriter);
                generator.generate(data.getItems());

            } else {
                LOGGER.log(Level.INFO, "Chave de api não foi digitada.");
            }
        } catch (IOException | InterruptedException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}
