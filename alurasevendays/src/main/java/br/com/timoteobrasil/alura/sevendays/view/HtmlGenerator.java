package br.com.timoteobrasil.alura.sevendays.view;

import java.io.PrintWriter;
import java.lang.System.Logger;
import java.lang.System.LoggerFinder;
import java.lang.System.Logger.Level;
import java.text.MessageFormat;
import java.util.List;

import br.com.timoteobrasil.alura.sevendays.model.Top250DataDetail;

public class HtmlGenerator {

    private static final Logger LOGGER = LoggerFinder.getLoggerFinder().getLogger(HtmlGenerator.class.getName(),
            HtmlGenerator.class.getModule());

    private PrintWriter writer;

    private String template;

    public HtmlGenerator(PrintWriter writer) {
        super();
        this.writer = writer;
        this.template = initTemplate();
    }

    public void generate(List<Top250DataDetail> movies) {
        LOGGER.log(Level.INFO, "Gerando saída HTML.");
        writer.println(MessageFormat.format(template, generateHead(), generateBody(movies)));
        LOGGER.log(Level.INFO, "Geração de arquivo HTML concluída.");
    }

    private String initTemplate() {
        // Ignorando a dica de usar textBlocks pq estou usando Java 11
        StringBuilder builder = new StringBuilder("<html>\n");
        builder.append("<head>\n")
            // substituir coisas do head no primeiro parâmetro
            .append("{0}\n")
            .append("</head>\n")
            .append("<body>\n")
            // substituir coisas do body no segundo parâmetro
            .append("{1}\n")
            .append("</body>\n")
            .append("</html>")
        ;

        return builder.toString();
    }

    private String generateHead() {
        // Usando a sugestão de importar o bootstrap
        return "<meta charset=\"utf-8\">\n" 
            + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n"
	        + "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" "
		    + "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">";
    }

    private String generateBody(List<Top250DataDetail> movies) {

        if(movies == null || movies.isEmpty()) {
            return "<h2>No items.</h2>";
        }

        StringBuilder bodyBuilder = new StringBuilder("<div>\n"); //BIRL!!!!
        for (Top250DataDetail movie : movies) {
            bodyBuilder.append(generateDiv(movie))
                .append("\n");
        }
        bodyBuilder.append("</div>\n");

        return bodyBuilder.toString();
    }

    private String generateDiv(Top250DataDetail movie) {
        // TODO externalizar esses templates
        // TODO usar alguma biblioteca pra nomear esses parâmetros
        StringBuilder divTemplateBuilder = new StringBuilder()
            .append("<div class=\"card text-white bg-dark mb-3\" style=\"max-width: 18rem;\">\n")
            .append("    <h4 class=\"card-header\">{0}</h4>\n")
            .append("    <div class=\"card-body\">\n")
            .append("        <img class=\"card-img\" src=\"{1}\" alt=\"{2}\">\n")
            .append("        <p class=\"card-text mt-2\">Nota: {3} - Ano: {4}</p>\n")
            .append("    </div>\n")
            .append("</div>")
        ;

        return MessageFormat.format(divTemplateBuilder.toString(), movie.getTitle(), movie.getImage(),
                movie.getFullTitle(), movie.getImDbRating(), movie.getYear());
    }
}
