package com.pens.travelme.travelme.frag_lets.recommend;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pens.travelme.travelme.MainActivity;
import com.pens.travelme.travelme.R;
import com.pens.travelme.travelme.frag_lets.recommend.recommend_hotel.ReHotelFragment;
import com.pens.travelme.travelme.frag_lets.recommend.recommend_restaurant.ReRestaurantFragment;
import com.pens.travelme.travelme.frag_lets.recommend.recommend_travel.ReTravelFragment;
import com.pens.travelme.travelme.modal.MyChoice;

import static com.pens.travelme.travelme.frag_lets.LetsActivity.MYCHOICE;

public class RecommendActivity extends AppCompatActivity {
    public static final String RECOMEND_ACTIVITY_TAG = "RecommendActivity";

    public static final String TRAVEL = "TRAVEL";
    public static final String HOTEL = "HOTEL";
    public static final String RESTAURANT = "RESTAURANT";
    public static String currentFragment = TRAVEL;

    public MyChoice myChoice = new MyChoice();

    private RelativeLayout rvNext;
    private ProgressBar pbBudget;
    private TextView tvMyBudget;
    private TextView tvTotalBudget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        myChoice = getIntent().getParcelableExtra(MYCHOICE);

        pbBudget = (ProgressBar) findViewById(R.id.pb_budget);
        tvMyBudget = (TextView) findViewById(R.id.tv_my_budget);
        tvTotalBudget = (TextView) findViewById(R.id.tv_total_budget);
        rvNext = (RelativeLayout) findViewById(R.id.rv_next);

        pbBudget.setIndeterminate(false);
        pbBudget.setMax(myChoice.getBudget().intValue());
        pbBudget.setProgress(myChoice.getBudget().intValue());
        tvMyBudget.setText("Rp "+ myChoice.getBudget());
        tvTotalBudget.setText("Rp "+ myChoice.getBudget());

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

    public MyChoice getMyChoice() {
        return myChoice;
    }

    public ProgressBar getPbBudget() {
        return pbBudget;
    }

    public TextView getTvMyBudget() {
        return tvMyBudget;
    }
}
