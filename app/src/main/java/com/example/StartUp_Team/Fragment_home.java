package com.example.StartUp_Team;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

public class Fragment_home extends Fragment {

    Fragment_profile fragment_profile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);

        fragment_profile = new Fragment_profile();

        ImageButton button = rootView.findViewById(R.id.Button_profile);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) getActivity();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment_profile).commit();
            }
        });

        return rootView;
    }

}
