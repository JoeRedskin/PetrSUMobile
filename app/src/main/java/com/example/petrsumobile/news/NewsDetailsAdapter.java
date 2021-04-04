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
        titleTextView.setText(currentNews.getTitle());

        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.textViewDescriptionDetails);
        descriptionTextView.setText(currentNews.getDescription());

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.textViewDateDetails);
        dateTextView.setText(currentNews.getDate().toString());


       /* ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        iconView.setImageResource(currentAndroidFlavor.getImageResourceId()); */

        return listItemView;
    }
}
