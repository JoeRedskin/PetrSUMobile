/*package com.example.petrsumobile;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<News> newsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        newsList = new ArrayList<News>();

        newsList.add(new News(
                "titletitletitletitletitletitletitletitle",
                "descriptriooooooooooooodescriptriooooooooooooo" +
                        "descriptriooooooooooooodescriptriooooooooooooo" +
                        "descriptriooooooooooooodescriptriooooooooooooo",
                "www.ya.ru",
                "28.04.2020",
                "image"));
        newsList.add(new News(
                "BIG TITLE GOOD NEWS",
                "description about description",
                "www.ya.ru",
                "27.04.2020",
                "image"));
        newsList.add(new News(
                "1BIG TITLE GOOD NEWS",
                "description about description",
                "www.ya.ru",
                "27.04.2020",
                "image"));
        newsList.add(new News(
                "2BIG TITLE GOOD NEWS",
                "description about description",
                "www.ya.ru",
                "27.04.2020",
                "image"));
        newsList.add(new News(
                "3BIG TITLE GOOD NEWS",
                "description about description",
                "www.ya.ru",
                "27.04.2020",
                "image"));

        NewsAdapter newsAdapter = new NewsAdapter(this, newsList);

        recyclerView = (RecyclerView) findViewById(R.id.recycle_view_news);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new CustomAdapter(newsList);
        recyclerView.setAdapter(adapter);

    }
}*/
