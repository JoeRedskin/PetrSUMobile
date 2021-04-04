 /*package com.example.petrsumobile;

import java.util.HashMap;

public class NewsRepository {
    private String news[];
    private HashMap<Integer, News> newsDetails;
    public String[] getNews(){
        if(news == null){
            news = new String[7];
            news[0] = "Rafael Nadal";
            news[1] = "Roger Federer";
            news[2] = "Juan Martin del Potro";
            news[3] = "Alexander Zverev";
            news[4] = "Grigor Dimitrov";
            news[5] = "Kevin Anderson";
            news[6] = "Marin Cilic";
        }
        return news;
    }

    public News getNewsDetails(Integer index){
        if(newsDetails == null){
            createPlayerDetailsMap();
        }
        return newsDetails.get(index);
    }

    public void createPlayerDetailsMap(){
        newsDetails = new HashMap<Integer, News>();

        News player = new News("titletitletitletitletitletitletitletitle",
                "descriptriooooooooooooodescriptriooooooooooooo" +
                        "descriptriooooooooooooodescriptriooooooooooooo" +
                        "descriptriooooooooooooodescriptriooooooooooooo",
                "www.ya.ru",
                "28.04.2020",
                "image");
        newsDetails.put(0, player);

        player = new News(
                "BIG TITLE GOOD NEWS",
                "description about description",
                "www.ya.ru",
                "27.04.2020",
                "image");
        newsDetails.put(1, player);

        player = new News(
                "1BIG TITLE GOOD NEWS",
                "description about description",
                "www.ya.ru",
                "27.04.2020",
                "image");
        newsDetails.put(2, player);

        player = new News(
                "2BIG TITLE GOOD NEWS",
                "description about description",
                "www.ya.ru",
                "27.04.2020",
                "image");
        newsDetails.put(3, player);

        player = new News(
                "3BIG TITLE GOOD NEWS",
                "description about description",
                "www.ya.ru",
                "27.04.2020",
                "image");
        newsDetails.put(4, player);

    }
}*/
