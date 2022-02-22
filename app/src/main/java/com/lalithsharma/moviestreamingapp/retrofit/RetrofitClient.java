package com.lalithsharma.moviestreamingapp.retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetrofitClient {

    // base url
    private  static final String BASE_URl ="";
    public static ApiInterface getRetrofitClient(){

        Retrofit.Builder builder = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URl);

            return builder.build().create(ApiInterface.class);
    }


}
