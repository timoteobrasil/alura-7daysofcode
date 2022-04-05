package br.com.timoteobrasil.alura.sevendays.parser;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.timoteobrasil.alura.sevendays.model.Top250Data;
import br.com.timoteobrasil.alura.sevendays.model.Top250DataDetail;

public class Top250DataParserTest {

    String jsonDeTeste = "{\"items\":[{\"id\":\"tt0111161\",\"rank\":\"1\",\"title\":\"The Shawshank Redemption\",\"fullTitle\":\"The Shawshank Redemption (1994)\",\"year\":\"1994\",\"image\":\"https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX128_CR0,3,128,176_AL_.jpg\",\"crew\":\"Frank Darabont (dir.), Tim Robbins, Morgan Freeman\",\"imDbRating\":\"9.2\",\"imDbRatingCount\":\"2568069\"},{\"id\":\"tt0068646\",\"rank\":\"2\",\"title\":\"The Godfather\",\"fullTitle\":\"The Godfather (1972)\",\"year\":\"1972\",\"image\":\"https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UX128_CR0,1,128,176_AL_.jpg\",\"crew\":\"Francis Ford Coppola (dir.), Marlon Brando, Al Pacino\",\"imDbRating\":\"9.2\",\"imDbRatingCount\":\"1767927\"},{\"id\":\"tt0468569\",\"rank\":\"3\",\"title\":\"The Dark Knight\",\"fullTitle\":\"The Dark Knight (2008)\",\"year\":\"2008\",\"image\":\"https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_UX128_CR0,3,128,176_AL_.jpg\",\"crew\":\"Christopher Nolan (dir.), "
            + "Christian Bale, Heath Ledger\",\"imDbRating\":\"9.0\",\"imDbRatingCount\":\"2532564\"},{\"id\":\"tt0071562\",\"rank\":\"4\",\"title\":\"The Godfather: Part II\",\"fullTitle\":\"The Godfather: Part II (1974)\",\"year\":\"1974\",\"image\":\"https://m.media-amazon.com/images/M/MV5BMWMwMGQzZTItY2JlNC00OWZiLWIyMDctNDk2ZDQ2YjRjMWQ0XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UX128_CR0,1,128,176_AL_.jpg\",\"crew\":\"Francis Ford Coppola (dir.), Al Pacino, Robert De Niro\",\"imDbRating\":\"9.0\",\"imDbRatingCount\":\"1223173\"}],\"errorMessage\":\"\"}";
    
    @Before
    public void setUp() {
        
    }
    
    @Test
    public void testParseItemsToStringList() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("\"id\":\"tt0111161\",\"rank\":\"1\",\"title\":\"The Shawshank Redemption\",\"fullTitle\":\"The Shawshank Redemption (1994)\",\"year\":\"1994\",\"image\":\"https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX128_CR0,3,128,176_AL_.jpg\",\"crew\":\"Frank Darabont (dir.), Tim Robbins, Morgan Freeman\",\"imDbRating\":\"9.2\",\"imDbRatingCount\":\"2568069\"");
        expected.add("\"id\":\"tt0068646\",\"rank\":\"2\",\"title\":\"The Godfather\",\"fullTitle\":\"The Godfather (1972)\",\"year\":\"1972\",\"image\":\"https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UX128_CR0,1,128,176_AL_.jpg\",\"crew\":\"Francis Ford Coppola (dir.), Marlon Brando, Al Pacino\",\"imDbRating\":\"9.2\",\"imDbRatingCount\":\"1767927\"");
        expected.add("\"id\":\"tt0468569\",\"rank\":\"3\",\"title\":\"The Dark Knight\",\"fullTitle\":\"The Dark Knight (2008)\",\"year\":\"2008\",\"image\":\"https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_UX128_CR0,3,128,176_AL_.jpg\",\"crew\":\"Christopher Nolan (dir.), Christian Bale, Heath Ledger\",\"imDbRating\":\"9.0\",\"imDbRatingCount\":\"2532564\"");
        expected.add("\"id\":\"tt0071562\",\"rank\":\"4\",\"title\":\"The Godfather: Part II\",\"fullTitle\":\"The Godfather: Part II (1974)\",\"year\":\"1974\",\"image\":\"https://m.media-amazon.com/images/M/MV5BMWMwMGQzZTItY2JlNC00OWZiLWIyMDctNDk2ZDQ2YjRjMWQ0XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UX128_CR0,1,128,176_AL_.jpg\",\"crew\":\"Francis Ford Coppola (dir.), Al Pacino, Robert De Niro\",\"imDbRating\":\"9.0\",\"imDbRatingCount\":\"1223173\"");

        Top250DataParser parser = new Top250DataParser();
        Assert.assertEquals(expected, parser.parseItemsToStringList(jsonDeTeste));
    }

    @Test
    public void testParse() {

        Top250DataParser parser = new Top250DataParser();
        Top250Data expected = new Top250Data();
        List<Top250DataDetail> listDetails = new ArrayList<>();
        
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
        listDetails.add(detail);
        
        detail = new Top250DataDetail();
        detail.setId("tt0068646");
        detail.setRank("2");
        detail.setTitle("The Godfather");
        detail.setFullTitle("The Godfather (1972)");
        detail.setYear("1972");
        detail.setImage("https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UX128_CR0,1,128,176_AL_.jpg");
        detail.setCrew("Francis Ford Coppola (dir.), Marlon Brando, Al Pacino");
        detail.setImDbRating("9.2");
        detail.setImDbRatingCount("1767927");
        listDetails.add(detail);
        
        detail = new Top250DataDetail();
        detail.setId("tt0468569");
        detail.setRank("3");
        detail.setTitle("The Dark Knight");
        detail.setFullTitle("The Dark Knight (2008)");
        detail.setYear("2008");
        detail.setImage("https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_UX128_CR0,3,128,176_AL_.jpg");
        detail.setCrew("Christopher Nolan (dir.), Christian Bale, Heath Ledger");
        detail.setImDbRating("9.0");
        detail.setImDbRatingCount("2532564");
        listDetails.add(detail);
        
        detail = new Top250DataDetail();
        detail.setId("tt0071562");
        detail.setRank("4");
        detail.setTitle("The Godfather: Part II");
        detail.setFullTitle("The Godfather: Part II (1974)");
        detail.setYear("1974");
        detail.setImage("https://m.media-amazon.com/images/M/MV5BMWMwMGQzZTItY2JlNC00OWZiLWIyMDctNDk2ZDQ2YjRjMWQ0XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UX128_CR0,1,128,176_AL_.jpg");
        detail.setCrew("Francis Ford Coppola (dir.), Al Pacino, Robert De Niro");
        detail.setImDbRating("9.0");
        detail.setImDbRatingCount("1223173");
        listDetails.add(detail);

        expected.setItems(listDetails);
        
        Assert.assertEquals(expected, parser.parse(jsonDeTeste));
    }
}
