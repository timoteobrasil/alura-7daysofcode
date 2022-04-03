package br.com.timoteobrasil.alura.sevendays.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Top250DataDetailParser {

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
}