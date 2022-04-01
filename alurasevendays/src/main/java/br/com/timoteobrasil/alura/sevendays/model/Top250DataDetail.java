package br.com.timoteobrasil.alura.sevendays.model;

public class Top250DataDetail {
    private String id;
    private String rank;
    private String title;
    private String fullTitle;
    private String year;
    private String image;
    private String crew;
    private String iMDbRating;
    private String iMDbRatingCount;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getRank() {
        return rank;
    }
    public void setRank(String rank) {
        this.rank = rank;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getFullTitle() {
        return fullTitle;
    }
    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getCrew() {
        return crew;
    }
    public void setCrew(String crew) {
        this.crew = crew;
    }
    public String getiMDbRating() {
        return iMDbRating;
    }
    public void setiMDbRating(String iMDbRating) {
        this.iMDbRating = iMDbRating;
    }
    public String getiMDbRatingCount() {
        return iMDbRatingCount;
    }
    public void setiMDbRatingCount(String iMDbRatingCount) {
        this.iMDbRatingCount = iMDbRatingCount;
    }
    
}
