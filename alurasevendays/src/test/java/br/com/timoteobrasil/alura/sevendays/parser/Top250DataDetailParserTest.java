package br.com.timoteobrasil.alura.sevendays.parser;

import org.junit.Assert;
import org.junit.Test;

import br.com.timoteobrasil.alura.sevendays.model.Top250DataDetail;

public class Top250DataDetailParserTest {
    
    @Test
    public void testParse() {
        String json = "{\"id\":\"tt0111161\",\"rank\":\"1\",\"title\":\"The Shawshank Redemption\",\"fullTitle\":\"The Shawshank Redemption (1994)\",\"year\":\"1994\",\"image\":\"https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX128_CR0,3,128,176_AL_.jpg\",\"crew\":\"Frank Darabont (dir.), Tim Robbins, Morgan Freeman\",\"imDbRating\":\"9.2\",\"imDbRatingCount\":\"2568069\"}";
        Top250DataDetail detail = new Top250DataDetail();
        detail.setId("tt0111161");
        detail.setRank("1");
        detail.setTitle("The Shawshank Redemption");
        detail.setFullTitle("The Shawshank Redemption (1994)");
        detail.setYear("1994");
        detail.setImage("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX128_CR0,3,128,176_AL_.jpg");
        detail.setCrew("Frank Darabont (dir.), Tim Robbins, Morgan Freeman");
        detail.setImDbRating("9.2");
        detail.setImDbRatingCount("2568069");

        Top250DataDetailParser parser = new Top250DataDetailParser();
        Assert.assertEquals(detail, parser.parse(json));
    }
}
