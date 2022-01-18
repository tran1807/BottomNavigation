package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

//import info.androidhive.bottomnavigation.fragment.CartFragment;
//import info.androidhive.bottomnavigation.fragment.GiftsFragment;
//import info.androidhive.bottomnavigation.fragment.ProfileFragment;
//import info.androidhive.bottomnavigation.fragment.StoreFragment;
//import info.androidhive.bottomnavigation.helper.BottomNavigationBehavior;


public class MainActivity extends AppCompatActivity {

    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();

        // load the store fragment by default
        toolbar.setTitle("Shop");
        loadFragment(new StoreFragment());


    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_shop:
                    toolbar.setTitle("Shop");
                    fragment = new StoreFragment();
                    loadFragment((StoreFragment) fragment);
                    return true;
                case R.id.navigation_gifts:
                    toolbar.setTitle("My Gifts");
                    fragment = new GiftsFragment();
                    loadFragment((StoreFragment) fragment);
                    return true;
                case R.id.navigation_cart:
                    toolbar.setTitle("Cart");
                    fragment = new CartFragment();
                    loadFragment((StoreFragment) fragment);
                    return true;
                case R.id.navigation_profile:
                    toolbar.setTitle("Profile");
                    fragment = new ProfileFragment();
                    loadFragment((StoreFragment) fragment);
                    return true;
        }
            return false;
    }
        };
    private void loadFragment(StoreFragment storeFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, storeFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}