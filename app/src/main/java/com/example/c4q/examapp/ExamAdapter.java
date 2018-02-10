package com.example.c4q.examapp;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by c4q on 1/9/18.
 */

public class ExamAdapter extends RecyclerView.Adapter<ExamViewHolder> {
    private List<PokeModel> pokeModelList = new ArrayList<>();
    private Context context;
    private Parcel in;
    private Abilities.Ability ability= new Abilities.Ability();

    public ExamAdapter(List<PokeModel> pokeModelList) {
        this.pokeModelList = pokeModelList;
    }

    @Override
    public ExamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.exam_itemview, parent, false);
        context = childView.getContext();
        return new ExamViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(final ExamViewHolder holder, final int position) {
        holder.onBind(pokeModelList.get(position));



    }

    @Override
    public int getItemCount() {

        return pokeModelList.size();
    }
}
/*
DROP TABLE IF EXISTS movies;


CREATE TABLE movies(_id INTEGER PRIMARY KEY,title TEXT, director TEXT, release_year INTEGER);

INSERT INTO movies(title,director,release_year) VALUES('Avengers','Joss Wheadon',2012);
INSERT INTO movies(title,director,release_year) VALUES('BLACK PANTHER', 'RYAN COOGLER',2018);
INSERT INTO movies(title, director,release_year) VALUES('Inception','',2010);
INSERT INTO movies(title, director, release_year) VALUES('Batman Begins','Christopher Nolan',2012);
SELECT * from movies;
SELECT * FROM movies ORDER BY release_year DESC;
SELECT * FROM movies ORDER BY LENGTH(title) DESC;

 */






