package io.javabrains.moviecatalogservice.model;

import org.springframework.stereotype.Component;

@Component
public class CatalogItem {

    private String catalogName;
    private String catalogDescription;
    private int rating;

    //Getter and Setter methods


    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getCatalogDescription() {
        return catalogDescription;
    }

    public void setCatalogDescription(String catalogDescription) {
        this.catalogDescription = catalogDescription;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public CatalogItem(String catalogName, String catalogDescription, int rating) {
        this.catalogName = catalogName;
        this.catalogDescription = catalogDescription;
        this.rating = rating;
    }

    public CatalogItem() {
    }

}
