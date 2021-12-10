package com.example.StartUp_Team;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class Fragment_team_create extends Fragment {

    Fragment_team fragment_team;
    Fragment_team_create_recommend fragment_team_create_recommend;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_team_create, container, false);

        fragment_team = new Fragment_team();
        fragment_team_create_recommend = new Fragment_team_create_recommend();

        ImageButton button = rootView.findViewById(R.id.button_close);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) getActivity();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment_team).commit();
            }
        });

        ImageButton team_create_button = rootView.findViewById(R.id.team_create_button);
        team_create_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) getActivity();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment_team_create_recommend).commit();
            }
        });

        return rootView;
    } 
}