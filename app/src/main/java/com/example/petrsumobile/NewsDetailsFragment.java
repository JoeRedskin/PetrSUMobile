package com.example.petrsumobile;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProviders;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsDetailsFragment extends Fragment {

    TextView textViewDateDetails;
    TextView textViewTitleDetails;
    TextView textViewDescriptionDetails;
    ImageView imageView;

    public NewsDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_details, container, false);

        //TODO: navigation not work
       // ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Новости");


        textViewDateDetails = (TextView) view.findViewById(R.id.textViewDateDetails);
        textViewTitleDetails = (TextView) view.findViewById(R.id.textViewTitleDetails);
        textViewDescriptionDetails = (TextView) view.findViewById(R.id.textViewDescriptionDetails);
        imageView = (ImageView) view.findViewById(R.id.imageViewNewsDetails);

        return view;
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NewsViewModel newsViewModel = ViewModelProviders.of(this.getActivity()).get(NewsViewModel.class);

        /*newsViewModel.getSelectedNews().observe(getViewLifecycleOwner(), item -> {
            displayDetails(newsViewModel.getNews());
        });*/

        displayDetails(newsViewModel.getSelectedNews());

    }

    public void displayDetails(News news){

        String formattedDate = formatDate(news.getNewsDate());
        String imageViewURL = news.getNewsImageURL();

        textViewDateDetails.setText(formattedDate);
        textViewTitleDetails.setText(news.getNewsTitle());
        textViewDescriptionDetails.setText(news.getNewsDescription());



        Glide.with(this)
                .load(imageViewURL)
                .centerCrop()
//                .skipMemoryCache(true)
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.ic_placeholder)
                .into(imageView);
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM, yyyy");
        return dateFormat.format(dateObject);
    }
}
