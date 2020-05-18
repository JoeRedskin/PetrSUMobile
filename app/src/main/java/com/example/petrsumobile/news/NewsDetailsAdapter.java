package com.example.petrsumobile.news;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.example.petrsumobile.R;

import java.util.ArrayList;

public class NewsDetailsAdapter extends ArrayAdapter<News> {

    public NewsDetailsAdapter(Activity context, ArrayList<News> news) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, news);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        News currentNews = getItem(position);

        TextView titleTextView = (TextView) listItemView.findViewById(R.id.textViewTitleDetails);
        titleTextView.setText(currentNews.getNewsTitle());

        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.textViewDescriptionDetails);
        descriptionTextView.setText(currentNews.getNewsDescription());

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.textViewDateDetails);
        dateTextView.setText(currentNews.getNewsDate().toString());


       /* ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        iconView.setImageResource(currentAndroidFlavor.getImageResourceId()); */

        return listItemView;
    }
}
