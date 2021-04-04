package com.example.petrsumobile.news;

import java.util.Date;

public class News {

    private String title;
    private String description;
    private String link;
    private Date date;
    private String imageUrl;

    public News(String title, String description, Date date, String link, String imageUrl){
        this.title= title;
        this.description = description;
        this.link = link;
        this.date = date;
        this.imageUrl = imageUrl;
    }

    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    public String getLink(){
        return link;
    }
    public Date getDate(){
        return date;
    }
    public String getImageUrl(){
        return imageUrl;
    }

}
