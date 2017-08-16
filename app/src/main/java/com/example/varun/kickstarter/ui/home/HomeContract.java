package com.example.varun.kickstarter.ui.home;

import com.example.varun.kickstarter.model.Projects;

import java.util.ArrayList;

/**
 * Created by varun on 8/13/17.
 */

public interface HomeContract {

    interface  View {

        void onError(String message);

        void onSuccess();

        void loadData(ArrayList<Projects> projects);

        void start();

        void finish();

    }


    interface presenter
    {
       void getProjects();
    }

}
