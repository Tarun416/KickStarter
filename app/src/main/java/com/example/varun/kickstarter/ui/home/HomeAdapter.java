package com.example.varun.kickstarter.ui.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.varun.kickstarter.R;
import com.example.varun.kickstarter.interfaces.OnClick;
import com.example.varun.kickstarter.model.Projects;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by varun on 8/13/17.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Projects> projects;
    private OnClick onClick;

    public HomeAdapter(Context context, ArrayList<Projects> projects,OnClick onClick) {
        this.projects = projects;
        this.context = context;
        this.onClick=onClick;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.items, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Projects project = projects.get(position);
        holder.title.setText(project.getTitle());
        holder.pledged.setText("Pledged : "+project.getAmtpledged());
        holder.backers.setText("Backers : "+project.getNumbackers());
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.pledged)
        TextView pledged;
        @BindView(R.id.backers)
        TextView backers;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position=getAdapterPosition();
            if(position!=RecyclerView.NO_POSITION)
            {
                onClick.onProjectClick(position);
            }

        }
    }
}
