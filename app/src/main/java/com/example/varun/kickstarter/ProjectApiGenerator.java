package com.example.varun.kickstarter.ui;

import android.util.Log;

import com.squareup.okhttp.OkHttpClient;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

import static android.content.ContentValues.TAG;

/**
 * Created by varun on 8/13/17.
 */

public class ProjectApiGenerator {

    public static String BASE_URL = "http://starlord.hackerearth.com/";



    public static RequestInterceptor requestInterceptor;
    private static RestAdapter adapter;

    public ProjectApiGenerator() {
    }

    public static <S> S createService(Class<S> serviceClass) {

        OkHttpClient okHttpClient = new OkHttpClient();

            requestInterceptor = new RequestInterceptor() {
                @Override public void intercept(RequestFacade request) {
                    request.addHeader("Accept", "application/json");
                    request.addHeader("Content-Type", "application/x-www-form-urlencoded");
                }
            };
            RestAdapter.Builder builder = new RestAdapter.Builder().setEndpoint(BASE_URL)
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setLog(new RestAdapter.Log() {
                        @Override public void log(String msg) {
                            Log.e(TAG,msg);
                        }
                    })
                    .setClient(new OkClient(okHttpClient))
                    .setRequestInterceptor(requestInterceptor);

            adapter = builder.build();

        return adapter.create(serviceClass);
    }

}
