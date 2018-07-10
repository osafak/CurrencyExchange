package com.osafak.currencyexchange;


import okhttp3.OkHttpClient;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Onur on 1.11.2016.
 */

public class Retrofit {
    public static String baseUrl="https://www.doviz.com";

    public static retrofit2.Retrofit retrofit;
    private static retrofit2.Retrofit.Builder builder=new retrofit2.Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create());
    private static OkHttpClient.Builder httpClient=new OkHttpClient.Builder();
    public static <S> S createService(Class<S> serviceClass)
    {
        builder.client(httpClient.build());
        retrofit=builder.build();
        return retrofit.create(serviceClass);
    }


}
