package com.example.c4q.examapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private PokeModel model;
    private List<PokeModel> pokeModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pokeModelList = new ArrayList<>();
        retrofitStuff();


    }

    public void retrofitStuff() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        Log.d("Retrofit", message);
                    }
                }))
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final PokeApi pokeService = retrofit.create(PokeApi.class);
        Call<PokemonInfo> pokemons = pokeService.getModels(150);
        pokemons.enqueue(new Callback<PokemonInfo>() {
            @Override
            public void onResponse(Call<PokemonInfo> call, Response<PokemonInfo> response) {


                pokeModelList = response.body().getModelList();

                Log.d(TAG, "onResponse: " + pokeModelList.size());
                PokeFragment pokeFragment = new PokeFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.pokeFragment, pokeFragment);
                fragmentTransaction.addToBackStack("creature");
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("creature", (ArrayList<? extends Parcelable>) pokeModelList);
                bundle.putString("you", pokeModelList.get(1).getName());
                pokeFragment.setArguments(bundle);
                fragmentTransaction.commit();

            }

            @Override
            public void onFailure(Call<PokemonInfo> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }


}



