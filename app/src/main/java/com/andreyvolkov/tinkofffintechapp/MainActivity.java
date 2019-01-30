package com.andreyvolkov.tinkofffintechapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.andreyvolkov.tinkofffintechapp.Fragments.AccountFragment;
import com.andreyvolkov.tinkofffintechapp.Helpers.BottomNavigationViewHelper;
import com.andreyvolkov.tinkofffintechapp.Model.APIClient;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class MainActivity extends AppCompatActivity {

    private static final int ACTIVITY_NUM = 0;
    private APIClient client = new APIClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        client.getPosts();
        init();
    }

    private void init() {
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.main_bottom_navigation_view);
        bottomNavigationViewEx.setOnNavigationItemSelectedListener(navListener);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);

        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);

        setListeners();
    }

    private void setListeners() {


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.navNewsFeed:
                            //selectedFragment = new CustomerSearchFragment();
                            break;
                        case R.id.navSchool:
                            //selectedFragment = new CustomerNewsfeedFragment();
                            break;
                        case R.id.navInternship:
                            //selectedFragment = new CustomerFavoritesFragment();
                            break;
                        case R.id.navAccount:
                            //selectedFragment = new CustomerFavoritesFragment();
                            break;
                    }
                    selectedFragment = new AccountFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_container, selectedFragment).commit();
                    return true;
                }
            };
}
