package com.example.c4q.examapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by c4q on 1/9/18.
 */

public interface PokeApi {//https://pokeapi.co/api/v2/pokemon/?limit=150
    @GET("pokemon")
    Call<PokemonInfo> getModels(@Query("limit") int limit);
    @GET("pokemon/{name}")
    Call<Pokemon> getAbilities(@Path("name") String pokeName);


}
