package com.lalithsharma.moviestreamingapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.lalithsharma.moviestreamingapp.Model.BannerMovies;
import com.lalithsharma.moviestreamingapp.MovieDetails;
import com.lalithsharma.moviestreamingapp.R;

import java.util.List;

public class BannerMoviesPagerAdapter  extends PagerAdapter {

    Context context;
    List<BannerMovies> bannerMoviesList;

    public BannerMoviesPagerAdapter(Context context, List<BannerMovies> bannerMoviesList) {
        this.context = context;
        this.bannerMoviesList = bannerMoviesList;
    }

    @Override
    public int getCount() {
        return bannerMoviesList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.banner_movie_layout,null);
        ImageView bannerImage = view.findViewById(R.id.banner_image);

        // glide library is used for fetching the image from url and setting it to image view
        Glide.with(context).load(bannerMoviesList.get(position).getImageUri()).into(bannerImage);
        container.addView(view);

        bannerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //    Toast.makeText(context, ""+bannerMoviesList.get(position).getMovieName(), Toast.LENGTH_SHORT).show();

                Intent i  = new Intent(context, MovieDetails.class);
                i.putExtra("movieId",bannerMoviesList.get(position).getId());
                i.putExtra("movieName",bannerMoviesList.get(position).getMovieName());
                i.putExtra("movieImageUri",bannerMoviesList.get(position).getImageUri());
                i.putExtra("movieFile",bannerMoviesList.get(position).getFileUrl());
                context.startActivity(i);
            }
        });

        return view;

    }
}
