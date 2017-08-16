package com.example.varun.kickstarter.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.varun.kickstarter.R;
import com.example.varun.kickstarter.interfaces.OnClick;
import com.example.varun.kickstarter.model.Projects;
import com.example.varun.kickstarter.ui.details.DetailsActivity;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by varun on 8/13/17.
 */

public class HomeActivity extends AppCompatActivity implements HomeContract.View ,OnClick{

    @BindView(R.id.projectsRecyclerView)
    RecyclerView projectsRecyclerView;
    @BindView(R.id.progreeBar)
    ProgressBar progreeBar;

    private HomePresenter homePresenter;
    private HomeAdapter homeAdapter;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<com.example.varun.kickstarter.model.Projects> projects;
    private static final String TAG=HomeActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        projects = new ArrayList<>();
        setRecyclerView();
        homePresenter = new HomePresenter(HomeActivity.this);
        homePresenter.getProjects();

    }

    private void setRecyclerView() {
        linearLayoutManager = new LinearLayoutManager(HomeActivity.this);
        projectsRecyclerView.setLayoutManager(linearLayoutManager);
        projectsRecyclerView.setHasFixedSize(true);
        homeAdapter = new HomeAdapter(HomeActivity.this, projects,this);
        projectsRecyclerView.setAdapter(homeAdapter);
    }

    @Override
    public void onError(String message) {
        Log.d(TAG, message);

    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void loadData(ArrayList<Projects> projectss) {
        projects.addAll(projectss);
        homeAdapter.notifyDataSetChanged();
    }

    @Override
    public void start() {
        progreeBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void finish() {
        progreeBar.setVisibility(View.GONE);
    }

    @Override
    public void onProjectClick(int position) {
        Intent intent=new Intent(HomeActivity.this, DetailsActivity.class);
        intent.putExtra("position",position);
        startActivity(intent);
    }
}
