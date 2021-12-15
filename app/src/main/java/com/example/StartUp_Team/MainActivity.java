package com.example.StartUp_Team;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    Fragment_home fragment_home;
    Fragment_team fragment_team;
    Fragment_challenge fragment_challenge;
    Fragment_gallery fragment_gallery;
    Fragment_funding fragment_funding;
    Fragment_profile fragment_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        fragment_home = new Fragment_home();
        fragment_team = new Fragment_team();
        fragment_challenge = new Fragment_challenge();
        fragment_gallery = new Fragment_gallery();
        fragment_funding = new Fragment_funding();
        fragment_profile = new Fragment_profile();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment_home).commit();

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tab_home:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, fragment_home).commit();

                        return true;
                    case R.id.tab_team:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, fragment_team).commit();

                        return true;
                    case R.id.tab_challenge:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, fragment_challenge).commit();

                        return true;

                    case R.id.tab_gallery:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, fragment_gallery).commit();

                        return true;

                    case R.id.tab_funding:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, fragment_funding).commit();

                        return true;
                }

                return false;
            }
        });

    }
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment).commit();
    }
}
