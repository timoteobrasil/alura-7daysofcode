package br.com.timoteobrasil;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    //TODO externalizar essa URI
    private static String URI_IMDB_TOP_250 = "https://imdb-api.com/en/API/Top250Movies/{apiKey}";
    public static void main( String[] args ) {
        // Dia 1: fazendo tudo no mainzão
        try(Scanner in = new Scanner(System.in)) {

            //pegando a chave da api pela CLI
            System.out.print("Chave da api: ");
            String chave = in.next().trim();
            if(chave != null) {
                URI uriComChave = URI.create(URI_IMDB_TOP_250.replace("{apiKey}", chave));
                HttpRequest request = HttpRequest.newBuilder().uri(uriComChave).GET().build();
                // imprimindo o retorno no terminal quando retornar
                HttpResponse<String> response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
                System.out.println("Response Status Code: "+ response.statusCode());
                System.out.println(response.body());
            } else {
                System.out.println("Chave de api não foi digitada.");
            }
        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
