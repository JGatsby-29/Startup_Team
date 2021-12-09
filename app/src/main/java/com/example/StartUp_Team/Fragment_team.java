package com.example.StartUp_Team;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class Fragment_team extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;
    Fragment_team_team fragment_team_team;
    Fragment_team_member fragment_team_member;
    Fragment_team_create fragment_team_create;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_team, container, false);

        fragment_team_team = new Fragment_team_team();
        fragment_team_member = new Fragment_team_member();
        fragment_team_create = new Fragment_team_create();

        ImageButton button_create = view.findViewById(R.id.button_create);
        button_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) getActivity();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment_team_create).commit();
            }
        });

        tabLayout = view.findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("원정대"));
        tabLayout.addTab(tabLayout.newTab().setText("원정대원"));

        viewPager = view.findViewById(R.id.viewPager);
        team_PageAdapter pageAdapter = new team_PageAdapter(getFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0 || tab.getPosition() == 1)
                    pageAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        return view;
    }

}
