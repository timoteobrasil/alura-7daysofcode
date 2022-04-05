package br.com.timoteobrasil.alura.sevendays.model;

import java.util.Objects;

public class Top250DataDetail {
    private String id;
    private String rank;
    private String title;
    private String fullTitle;
    private String year;
    private String image;
    private String crew;
    private String imDbRating;
    private String imDbRatingCount;
    
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
    public String getImDbRating() {
        return imDbRating;
    }
    public void setImDbRating(String imDbRating) {
        this.imDbRating = imDbRating;
    }
    public String getImDbRatingCount() {
        return imDbRatingCount;
    }
    public void setImDbRatingCount(String imDbRatingCount) {
        this.imDbRatingCount = imDbRatingCount;
    }
    @Override
    public int hashCode() {
        return Objects.hash(crew, fullTitle, id, imDbRating, imDbRatingCount, image, rank, title, year);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Top250DataDetail other = (Top250DataDetail) obj;
        return Objects.equals(crew, other.crew) && Objects.equals(fullTitle, other.fullTitle)
                && Objects.equals(id, other.id) && Objects.equals(imDbRating, other.imDbRating)
                && Objects.equals(imDbRatingCount, other.imDbRatingCount) && Objects.equals(image, other.image)
                && Objects.equals(rank, other.rank) && Objects.equals(title, other.title)
                && Objects.equals(year, other.year);
    }
    
}
