package com.example.StartUp_Team;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

public class Fragment_gallery extends Fragment {

    Fragment_gallery_list fragment_gallery_list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_gallery, container, false);

        fragment_gallery_list = new Fragment_gallery_list();

        ImageButton button = rootView.findViewById(R.id.button_gallery_list);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) getActivity();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment_gallery_list).commit();
            }
        });

        return rootView;
    }

}
