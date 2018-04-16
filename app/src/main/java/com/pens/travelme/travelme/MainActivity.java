package com.pens.travelme.travelme;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.pens.travelme.travelme.account.AccountFragment;
import com.pens.travelme.travelme.history.HistoryFragment;
import com.pens.travelme.travelme.home.HomeFragment;
import com.pens.travelme.travelme.lets_travel.LetsActivity;
import com.pens.travelme.travelme.travel.TravelFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationViewEx navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;

            switch (item.getItemId()) {
                case R.id.nav_home:
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.nav_travel:
                    fragment = new TravelFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.nav_lets:
                    Intent intent = new Intent(MainActivity.this, LetsActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.nav_history:
                    fragment = new HistoryFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.nav_account:
                    fragment = new AccountFragment();
                    loadFragment(fragment);
                    return true;
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        navigation = (BottomNavigationViewEx) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setTextVisibility(false);
        navigation.enableItemShiftingMode(false);
        navigation.enableShiftingMode(false);
        navigation.setIconSize(18, 18);
        navigation.setIconsMarginTop(32);

        loadFragment(new HomeFragment());
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (navigation.getSelectedItemId() == R.id.nav_lets) {
            navigation.setSelectedItemId(R.id.nav_home);
            loadFragment(new HomeFragment());
        }
    }

    @Override
    public void onBackPressed() {
        if (navigation.getSelectedItemId() != R.id.nav_home) {
            navigation.setSelectedItemId(R.id.nav_home);
            loadFragment(new HomeFragment());
        } else {
            super.onBackPressed();
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.disallowAddToBackStack();
        transaction.commit();
    }
}
