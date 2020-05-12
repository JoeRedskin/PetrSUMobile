/*package com.example.petrsumobile;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<News> newsSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        TextView textViewDescription;
        TextView textViewDate;
        //ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitleDetails);
            this.textViewDescription = (TextView) itemView.findViewById(R.id.textViewDescriptionDetails);
            this.textViewDate = (TextView) itemView.findViewById(R.id.textViewDateDetails);
            //this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    public CustomAdapter(ArrayList<News> data) {
        this.newsSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_list_item, parent, false);

        //view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewTitle = holder.textViewTitle;
        TextView textViewDescription = holder.textViewDescription;
        TextView textViewDate = holder.textViewDate;
        //ImageView imageViewIcon = holder.imageViewIcon;

        textViewTitle.setText(newsSet.get(listPosition).getNewsTitle());
        textViewDescription.setText(newsSet.get(listPosition).getNewsDescription());
        textViewDate.setText(newsSet.get(listPosition).getNewsDate());
        //textViewDate.setImageResource(dataSet.get(listPosition).getImage());

        /*
        Glide.with(context)
               .load(movie.getImage())
               .into(holder.thumbnail);

    }

   /* @Override
    public int getItemCount() {
        return newsSet.size();
    }
}*/