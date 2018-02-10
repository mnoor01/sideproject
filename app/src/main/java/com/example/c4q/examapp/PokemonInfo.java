package com.example.c4q.examapp;

import java.util.List;

/**
 * Created by c4q on 1/22/18.
 */

public class PokemonInfo {
    private int count;
    private List<PokeModel> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<PokeModel> getModelList() {
        return results;
    }

    public void setModelList(List<PokeModel> results) {
        this.results = results;
    }
}
