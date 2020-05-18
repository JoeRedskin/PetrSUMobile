package com.example.petrsumobile.news;

import android.media.Image;

import java.text.SimpleDateFormat;
import java.util.Date;

public class News {

    private String title;
    private String description;
    private String link;
    private Date date;
    private String imageURL;

    public News(String title, String description, Date date, String link, String imageURL){
        this.title= title;
        this.description = description;
        this.link = link;
        this.date = date;
        this.imageURL = imageURL;
    }

    public String getNewsTitle(){
        return title;
    }
    public String getNewsDescription(){
        return description;
    }
    public String getNewsLink(){
        return link;
    }
    public Date getNewsDate(){
        return date;
    }
    public String getNewsImageURL(){
        return imageURL;
    }

//    @Override
//    public String toString() {
//
//        SimpleDateFormat sdf = new SimpleDateFormat("d MMM, yyyy");
//
//        String result = sdf.format(this.getNewsDate());
//        return result;
//    }


}
