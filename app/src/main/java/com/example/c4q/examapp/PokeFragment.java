package com.example.c4q.examapp;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PokeFragment extends Fragment {
    private View rootView;
    private List<PokeModel> pokeModelList=new ArrayList<>();


    public PokeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_poke, container, false);


        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Inflate the layout for this fragment
        Bundle bundle=getArguments();
        String newStuff= bundle.getString("yoy");
        Toast.makeText(getContext(), "Frag", Toast.LENGTH_SHORT).show();
        pokeModelList = bundle.getParcelableArrayList("creature");
        RecyclerView recyclerView = rootView.findViewById(R.id.pokeRecyclerView);
        ExamAdapter adapter = new ExamAdapter(pokeModelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        recyclerView.setAdapter(adapter);
    }
}
