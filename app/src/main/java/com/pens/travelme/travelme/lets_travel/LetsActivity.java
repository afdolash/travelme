package com.pens.travelme.travelme.lets_travel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.pens.travelme.travelme.R;
import com.pens.travelme.travelme.lets_travel.recommend.RecommendActivity;

public class LetsActivity extends AppCompatActivity {

    private LinearLayout lnTravel, lnRestaurant, lnHotel, lnTravelDetail, lnRestaurantDetail, lnHotelDetail;
    private ImageView imgIcTravel, imgIcRestaurant, imgIcHotel;
    private RelativeLayout rvTravelling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lets);

        lnTravel = (LinearLayout) findViewById(R.id.ln_travel);
        lnRestaurant = (LinearLayout) findViewById(R.id.ln_restaurant);
        lnHotel = (LinearLayout) findViewById(R.id.ln_hotel);
        lnTravelDetail = (LinearLayout) findViewById(R.id.ln_travel_detail);
        lnRestaurantDetail = (LinearLayout) findViewById(R.id.ln_restaurant_detail);
        lnHotelDetail = (LinearLayout) findViewById(R.id.ln_hotel_detail);
        imgIcTravel = (ImageView) findViewById(R.id.img_travel_ic);
        imgIcRestaurant = (ImageView) findViewById(R.id.img_restaurant_ic);
        imgIcHotel = (ImageView) findViewById(R.id.img_hotel_ic);
        rvTravelling = (RelativeLayout) findViewById(R.id.rv_travelling);

        lnTravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lnTravelDetail.getVisibility() == View.GONE) {
                    lnTravelDetail.setVisibility(View.VISIBLE);
                    imgIcTravel.setImageResource(R.drawable.ic_ai_minus);
                } else {
                    lnTravelDetail.setVisibility(View.GONE);
                    imgIcTravel.setImageResource(R.drawable.ic_ai_plus);
                }
            }
        });

        lnRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lnRestaurantDetail.getVisibility() == View.GONE) {
                    lnRestaurantDetail.setVisibility(View.VISIBLE);
                    imgIcRestaurant.setImageResource(R.drawable.ic_ai_minus);
                } else {
                    lnRestaurantDetail.setVisibility(View.GONE);
                    imgIcRestaurant.setImageResource(R.drawable.ic_ai_plus);
                }
            }
        });

        lnHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lnHotelDetail.getVisibility() == View.GONE) {
                    lnHotelDetail.setVisibility(View.VISIBLE);
                    imgIcHotel.setImageResource(R.drawable.ic_ai_minus);
                } else {
                    lnHotelDetail.setVisibility(View.GONE);
                    imgIcHotel.setImageResource(R.drawable.ic_ai_plus);
                }
            }
        });

        rvTravelling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LetsActivity.this, RecommendActivity.class);
                startActivity(intent);
            }
        });
    }
}
