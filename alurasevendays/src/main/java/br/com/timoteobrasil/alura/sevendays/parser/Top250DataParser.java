package br.com.timoteobrasil.alura.sevendays.parser;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.lang.System.LoggerFinder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.timoteobrasil.alura.sevendays.model.Top250Data;

public class Top250DataParser {

    private static final Logger LOGGER = LoggerFinder.getLoggerFinder().getLogger(Top250DataParser.class.getName(), Top250DataParser.class.getModule());

    // estrutura esperada: {"items":[{}],restanteIgnorado}
    private Pattern jsonItems = Pattern.compile("\"items\":\\[\\{(.*)\\}\\]");

    /**
     * Parse de jsonzão em lista de String.
     * @deprecated substituído pelo parser do jackson. Será removido no próximo commit.
     * @param jsonzao
     * @return
     */
    @Deprecated
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

    /**
     * Faz o parse do objeto json para um {@link Top250Data} usando o Jackson. Retorna {@code null} se não for posível fazer o parse da String.
     * @param json String com um objeto para o parse.
     * @return O objeto parseado, ou {@code null} se não for possível fazer o parse.
     */
    public Top250Data parse(String jsonzao) {
        LOGGER.log(Level.INFO, "Chamando o parser do Top250Data usando ObjectMapper do Jackson");
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(jsonzao, Top250Data.class);
        } catch (JsonProcessingException e) {
            LOGGER.log(Level.ERROR, e);
            return null;
        }
    }
}
