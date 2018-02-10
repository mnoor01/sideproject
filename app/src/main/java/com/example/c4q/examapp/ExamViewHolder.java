package com.example.c4q.examapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by c4q on 1/9/18.
 */


public class ExamViewHolder extends ViewHolder {
    public final String TAG = getClass().getSimpleName();

    private TextView id;
    private TextView name;
    private TextView height;
    private Context context;
    private ImageView pokeView;
    List<PokeModel> modelList;

    public ExamViewHolder(View itemView) {
        super(itemView);
        id = (TextView) itemView.findViewById(R.id.pokeID);
        name = (TextView) itemView.findViewById(R.id.name);
        height = (TextView) itemView.findViewById(R.id.height);
        context = itemView.getContext();
        pokeView = (ImageView) itemView.findViewById(R.id.picHolder);

    }

    public void onBind(final PokeModel model) {
        id.setText(" " + " " + getIdFromURL(model.getUrl()));
        name.setText(model.getName());
        height.setText(" " + " " + model.describeContents());
        Log.d(TAG, "onBind: " + String.valueOf(getIdFromURL(model.getUrl())));
        Log.d(TAG,"onBind2"+model.getAbilities());


        Picasso.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + getIdFromURL(model.getUrl()) + ".png")
                .into(pokeView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFragment secondFragment = new SecondFragment();
                FragmentManager fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putString("pokename",model.getName());
                bundle.putInt("numb",getIdFromURL(model.getUrl()));
                PokeModel model = new PokeModel();
                Gson gson= new Gson();

                secondFragment.setArguments(bundle);

                fragmentTransaction.replace(R.id.pokeFragment, secondFragment).addToBackStack("you");

                fragmentTransaction.commit();
            }
        });




    }

    public int getIdFromURL(String URL) {
        String[] urlArray = URL.split("/");
        String lastElement=urlArray[urlArray.length-1];
        int id= Integer.valueOf(lastElement);

        return id;

    }


    //https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/
}
