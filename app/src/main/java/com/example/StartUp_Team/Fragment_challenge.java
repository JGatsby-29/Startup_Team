package com.example.StartUp_Team;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Fragment_challenge extends Fragment {

    TabLayout tabLayout;
    ViewPager2 viewPager;
    PageAdapter pagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_challenge, container, false);
        tabLayout = view.findViewById(R.id.tablayout);
        viewPager = view.findViewById(R.id.viewPager);
        pagerAdapter = new PageAdapter(this);

        pagerAdapter.addFragment(new Fragment_challenge_list());
        pagerAdapter.addFragment(new Fragment_challenge_party());
        pagerAdapter.addFragment(new Fragment_challenge_member());
        String[] tabLayoutTextArray= new String[]{"챌린지 목록", "파티 모집", "파티원 찾기"};

        viewPager.setAdapter(pagerAdapter);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(tabLayoutTextArray[position])
        ).attach();

        // 뷰페이저 충돌 방지
        viewPager.setSaveEnabled(false);

        return view;
    }

}
