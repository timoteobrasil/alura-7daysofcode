package br.com.timoteobrasil.alura.sevendays.parser;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.lang.System.LoggerFinder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Top250DataParser {

    private static final Logger LOGGER = LoggerFinder.getLoggerFinder().getLogger(Top250DataParser.class.getName(), Top250DataParser.class.getModule());

    // estrutura esperada: {"items":[{}],restanteIgnorado}
    private Pattern jsonItems = Pattern.compile("\"items\":\\[\\{(.*)\\}\\]");

    public List<String> parseItemsToStringList(String jsonzao) {
        LOGGER.log(Level.INFO, "Parseando o json em um array de String.");
        // Dia 2: usando só os métodos do javazão pra quebrar a string de entrada
        if(jsonzao == null || jsonzao.isBlank()) {
            return new ArrayList<>();
        }

        jsonzao = jsonzao.replaceAll("\\r?\\n", "");
        
        Matcher matcherJsonItems = jsonItems.matcher(jsonzao);
        if(matcherJsonItems.find()) {
            String group = matcherJsonItems.group(1);
            // o matcher já tira as chaves mais externas... vou splitar pela sequência "},{" pra tirar as chaves internas
            if(group != null) {
                return Arrays.asList(group.split("\\},\\{"));
            }
        }

        return new ArrayList<>();
    }
}
