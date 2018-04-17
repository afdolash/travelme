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
    public static final String RECOMEND_ACTIVITY_TAG = "RecommendActivity";

    public static final String TRAVEL = "TRAVEL";
    public static final String HOTEL = "HOTEL";
    public static final String RESTAURANT = "RESTAURANT";
    public static String currentFragment = TRAVEL;

    private RelativeLayout rvNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        rvNext = (RelativeLayout) findViewById(R.id.rv_next);

        rvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (currentFragment) {
                    case TRAVEL:
                        loadFragment(new ReHotelFragment());
                        currentFragment = HOTEL;
                        break;
                    case HOTEL:
                        loadFragment(new ReRestaurantFragment());
                        currentFragment = RESTAURANT;
                        break;
                    case RESTAURANT:
                        finish();
                        break;
                }
            }
        });

        loadFragment(new ReTravelFragment());
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
