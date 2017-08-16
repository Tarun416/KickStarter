package com.example.varun.kickstarter.api;

import com.example.varun.kickstarter.model.Projects;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by varun on 8/13/17.
 */

public interface ProjectApi {

    @GET("/kickstarter")
    void getProjects(Callback<ArrayList<Projects>> cb);
}
