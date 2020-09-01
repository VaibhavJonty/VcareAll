package com.tuteehub.vcareall.rest;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tuteehub.vcareall.BuildConfig;
import com.tuteehub.vcareall.utils.InternetStatus;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RestClient {
    public static final String API_USER_NAME = "admin";
    public static final String API_PASSWORD = "1234";
    public static ApiInterface apiInterface;
    //live
    public static String baseUrl = "http://heartover.com/";
    //test
//    public static String baseUrl = "http://35.154.254.157/"; //TODO Base URL

    public static ApiInterface getClient() {
        if (apiInterface == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    Request request = original.newBuilder()
                            .method(original.method(), original.body())
                            .build();
                    return chain.proceed(request);
                }
            });
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                // Can be Level.BASIC, Level.HEADERS, or Level.BODY
                // See http://square.github.io/okhttp/3.x/logging-interceptor/ to see the options.
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                builder.addInterceptor(httpLoggingInterceptor);
            }


            builder.connectTimeout(10, TimeUnit.MINUTES).readTimeout(10, TimeUnit.MINUTES);
            builder.build();
            OkHttpClient okHttpClient = builder.build();


            Retrofit client = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiInterface = client.create(ApiInterface.class);
        }
        return apiInterface;
    }

}