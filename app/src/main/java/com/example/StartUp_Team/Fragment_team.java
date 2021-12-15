package com.example.StartUp_Team;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Fragment_team extends Fragment {

    // 뷰 선언
    ImageButton button_create;
    TabLayout tabLayout;
    ViewPager2 viewPager;
    PageAdapter pagerAdapter;
    Fragment_team_create fragment_team_create;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_team, container, false);

        // XML에서 뷰 ID 가져오기
        button_create = view.findViewById(R.id.button_create);
        tabLayout = view.findViewById(R.id.tablayout);
        viewPager = view.findViewById(R.id.viewPager);
        pagerAdapter = new PageAdapter(this);
        
        // 상단 탭 프래그먼트 추가 및 아이디 생성
        pagerAdapter.addFragment(new Fragment_team_team());
        pagerAdapter.addFragment(new Fragment_team_member());
        String[] tabLayoutTextArray= new String[]{"원정대 목록", "원정대원 찾기"};

        // 어댑터 장착, 집어 넣어주기
        viewPager.setAdapter(pagerAdapter);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(tabLayoutTextArray[position])
        ).attach();

        // 뷰페이저 충돌 방지
        viewPager.setSaveEnabled(false);

        // 원정대 생성 + 버튼
        button_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(fragment_team_create.newInstance());
            }
        });

        return view;
    }

}
