package com.example.petrsumobile.news;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.petrsumobile.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<News> newsList;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClicked(int position, News news);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        TextView textViewDescription;
        TextView textViewDate;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitleDetails);
            this.textViewDescription = (TextView) itemView.findViewById(R.id.textViewDescriptionDetails);
            this.textViewDate = (TextView) itemView.findViewById(R.id.textViewDateDetails);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageViewNews);
        }
    }

    public NewsAdapter(Context context, ArrayList<News> newsList, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.newsList = newsList;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_list_item, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewTitle = holder.textViewTitle;
        TextView textViewDescription = holder.textViewDescription;
        TextView textViewDate = holder.textViewDate;
        ImageView imageView = holder.imageView;

        String formattedDate = formatDate(newsList.get(listPosition).getNewsDate());

        textViewTitle.setText(newsList.get(listPosition).getNewsTitle());
        textViewDescription.setText(newsList.get(listPosition).getNewsDescription());
        textViewDate.setText(formattedDate);
        String imageViewURL = newsList.get(listPosition).getNewsImageURL();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                activity.getSupportFragmentManager().beginTransaction();

                FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new NewsDetailsFragment());
                transaction.addToBackStack(null);
                transaction.commit();

                onItemClickListener.onItemClicked(listPosition, newsList.get(listPosition));
            }
        });

        Glide.with(context)
                .load(imageViewURL)
                .centerCrop()
//                .skipMemoryCache(true)
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.ic_placeholder)
                .into(imageView);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM, yyyy");
        return dateFormat.format(dateObject);
    }
}
