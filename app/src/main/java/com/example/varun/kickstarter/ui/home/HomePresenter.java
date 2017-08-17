package com.example.varun.kickstarter.ui.home;

import com.example.varun.kickstarter.ProjectApiGenerator;
import com.example.varun.kickstarter.api.ProjectApi;
import com.example.varun.kickstarter.model.Projects;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by varun on 8/13/17.
 */

public class HomePresenter implements HomeContract.presenter {

    private final HomeContract.View view;
    private ProjectApiGenerator projectApiGenerator;
    private ProjectApi projectApi;


    public HomePresenter(HomeContract.View view) {

        this.view = view;
    }


    @Override
    public void getProjects() {
        view.start();
        projectApi=projectApiGenerator.createService(ProjectApi.class);
        projectApi.getProjects(new Callback<ArrayList<Projects>>() {
            @Override
            public void success(ArrayList<Projects> projects, Response response) {
                view.finish();
                view.onSuccess();
                view.loadData(projects);
            }

            @Override
            public void failure(RetrofitError error) {
                view.finish();
               view.onError(error.getMessage());
            }
        });
    }
}
