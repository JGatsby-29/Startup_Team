package com.example.StartUp_Team;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class challenge_PageAdapter extends FragmentPagerAdapter {
    int tabCount;
    public challenge_PageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.tabCount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Fragment_challenge_list();
            case 1:
                return new Fragment_challenge_party();
            case 2:
                return new Fragment_challenge_member();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {

        return 0;
    }
}
