package com.lalithsharma.moviestreamingapp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.lalithsharma.moviestreamingapp.Model.CategoryItem;
import com.lalithsharma.moviestreamingapp.MovieDetails;
import com.lalithsharma.moviestreamingapp.R;

import java.util.List;

public class Item_Recycler_Adapter extends RecyclerView.Adapter<Item_Recycler_Adapter.ItemViewHolder> {


    
    Context context;
    List<CategoryItem> categoryItemList;

    public Item_Recycler_Adapter(Context context, List<CategoryItem> categoryItemList) {
        this.context = context;
        this.categoryItemList = categoryItemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.cat_recycler_row_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        // here we will fetch image from server so we will use glide library
        Glide.with(context).load(categoryItemList.get(position).getImageUri()).into(holder.itemImage);

        holder.itemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //    Toast.makeText(context, ""+categoryItemList.get(position).getMovieName(), Toast.LENGTH_SHORT).show();

                Intent i  = new Intent(context, MovieDetails.class);
                i.putExtra("movieId",categoryItemList.get(position).getId());
                i.putExtra("movieName",categoryItemList.get(position).getMovieName());
                i.putExtra("movieImageUri",categoryItemList.get(position).getImageUri());
                i.putExtra("movieFile",categoryItemList.get(position).getFileUrl());
                context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryItemList.size();
    }

    public static final class ItemViewHolder extends RecyclerView.ViewHolder{

        ImageView itemImage;


        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_image);

        }
    }
    
    
    
    
    
}
