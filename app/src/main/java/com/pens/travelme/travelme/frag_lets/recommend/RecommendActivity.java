package com.pens.travelme.travelme.frag_lets.recommend;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.pens.travelme.travelme.R;
import com.pens.travelme.travelme.frag_lets.recommend.recommend_hotel.ReHotelFragment;
import com.pens.travelme.travelme.frag_lets.recommend.recommend_restaurant.ReRestaurantFragment;
import com.pens.travelme.travelme.frag_lets.recommend.recommend_travel.ReTravelFragment;

public class RecommendActivity extends AppCompatActivity {

    private final String TRAVEL = "TRAVEL";
    private final String HOTEL = "HOTEL";
    private final String RESTAURANT = "RESTAURANT";
    private String currentFragment = TRAVEL;

    private RelativeLayout rvNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        rvNext = (RelativeLayout) findViewById(R.id.rv_next);

        rvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentFragment == TRAVEL) {
                    loadFragment(new ReHotelFragment());
                    currentFragment = HOTEL;
                } else if (currentFragment == HOTEL) {
                    loadFragment(new ReRestaurantFragment());
                    currentFragment = RESTAURANT;
                } else if (currentFragment == RESTAURANT) {
                    finish();
                } else {
                    currentFragment = TRAVEL;
                }
            }
        });

        loadFragment(new ReTravelFragment());
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.disallowAddToBackStack();
        transaction.commit();
    }
}