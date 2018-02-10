package com.example.c4q.examapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {
    private static final String TAG = "SecondFragment";
    private View rootView;
    private TextView pokemonAbility;
    private TextView pokeNumbo;
    private Pokemon nuevoAility;


    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_second, container, false);
        setUpViews();

        // Inflate the layout for this fragment
        return rootView;
    }

    public void setUpViews() {
        pokemonAbility = rootView.findViewById(R.id.pokeAbilities);
        pokeNumbo = rootView.findViewById(R.id.pokeabs);
        Bundle bundle = getArguments();
        String pokename = bundle.getString("pokename");
        int pokeNumb = bundle.getInt("numb");
        Log.d(TAG, "onCreateView: " + pokeNumb);


        setupRetro(pokename);


//        pokemonAbility.setText(pokename);
        pokemonAbility.setText(pokename);
//        pokeNumbo.setText(nuevoAility.getAbilities()[pokeNumb].getAbility().getName());
    }

    public void setupRetro(String name) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        PokeApi service = retrofit.create(PokeApi.class);
        Call<Pokemon> ability = service.getAbilities(name);
        ability.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                nuevoAility = response.body();
                Log.d(TAG, "onResponse: " + nuevoAility.getAbilities()[0].getAbility().getName());
                pokeNumbo.setText(nuevoAility.getAbilities()[0].getAbility().getName());
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }


}
//kjncjdnsijcnds
