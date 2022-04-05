package br.com.timoteobrasil.alura.sevendays.parser;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.lang.System.LoggerFinder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.timoteobrasil.alura.sevendays.model.Top250DataDetail;

public class Top250DataDetailParser {

    private static final Logger LOGGER = LoggerFinder.getLoggerFinder().getLogger(Top250DataDetailParser.class.getName(), Top250DataDetailParser.class.getModule());

    /**
     * 
     * Parser que retorna o valor de uma chave em uma string com vário pares chave:valor
     * @deprecated Substituído pelo parser que usa Jackson e retorna o objeto inteiro. Será removido no próximo commit.
     * @param jsonObject
     * @param fieldName
     * @return
     */
    @Deprecated
    public String parseSingleField(String jsonObject, String fieldName) {
        if (jsonObject != null && !jsonObject.isBlank() && fieldName != null && !fieldName.isBlank()) {

            Pattern chaveValorPattern = Pattern.compile("\"" + fieldName + "\":\"([^\"]+)\"");
            Matcher matcherChaveValor = chaveValorPattern.matcher(jsonObject);
            
            if(matcherChaveValor.find()) {
                return matcherChaveValor.group(1);
            }
        }

        return null;
    }

    /**
     * Faz o parse do objeto json para um {@link Top250DataDetail} usando o Jackson. Retorna {@code null} se não for posível fazer o parse da String.
     * @param json String com um objeto para o parse.
     * @return O objeto parseado, ou {@code null} se não for possível fazer o parse.
     */
    public Top250DataDetail parse(String json) {
        LOGGER.log(Level.INFO, "Chamando o parser do Top250Data usando ObjectMapper do Jackson");
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, Top250DataDetail.class);
        } catch (JsonProcessingException e) {
            LOGGER.log(Level.ERROR, e);
            return null;
        }
    }
}