package com.pens.travelme.travelme.frag_lets;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pens.travelme.travelme.R;
import com.pens.travelme.travelme.frag_lets.recommend.RecommendActivity;

import java.util.ArrayList;
import java.util.List;

public class LetsActivity extends AppCompatActivity {

    private EditText etBudget;
    private TextView tvCatAlam, tvCatBuatan, tvMotor, tvCar, tvBus, tvAdult, tvChild, tvWisataDate,
            tvPorsi, tvKulinerDate, tvKamar, tvCheckInDate, tvCheckOutDate;
    private LinearLayout lnTravel, lnRestaurant, lnHotel, lnTravelDetail, lnRestaurantDetail,
            lnHotelDetail, lnCatAlam, lnCatBuatan, lnWisataDate, lnKulinerDate, lnCheckInDate,
            lnCheckOutDate;
    private ImageView imgIcTravel, imgIcRestaurant, imgIcHotel, imgCatAlam, imgCatBuatan;
    private RelativeLayout rvTravelling, rvMotorMin, rvMotorPlus, rvCarMin, rvCarPlus, rvBusMin,
            rvBusPlus, rvAdultMin, rvAdultPlus, rvChildMin, rvChildPlus, rvPorsiMin, rvPorsiPlus,
            rvKamarMin, rvKamarPlus;

    private List<String> categoryWisata = new ArrayList<>();
    private int ticketMotor, ticketCar, ticketBus, ticketAdult, ticketChild, jumPorsi, jumKamar = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lets);

        etBudget = (EditText) findViewById(R.id.et_budget);

        tvCatAlam = (TextView) findViewById(R.id.tv_cat_alam);
        tvCatBuatan = (TextView) findViewById(R.id.tv_cat_buatan);
        tvMotor = (TextView) findViewById(R.id.tv_motor);
        tvCar = (TextView) findViewById(R.id.tv_car);
        tvBus = (TextView) findViewById(R.id.tv_bus);
        tvAdult = (TextView) findViewById(R.id.tv_adult);
        tvChild = (TextView) findViewById(R.id.tv_child);
        tvWisataDate = (TextView) findViewById(R.id.tv_wisata_date);
        tvPorsi = (TextView) findViewById(R.id.tv_porsi);
        tvKulinerDate = (TextView) findViewById(R.id.tv_kuliner_date);
        tvKamar = (TextView) findViewById(R.id.tv_kamar);
        tvCheckInDate = (TextView) findViewById(R.id.tv_checkin_date);
        tvCheckOutDate = (TextView) findViewById(R.id.tv_checkout_date);

        lnTravel = (LinearLayout) findViewById(R.id.ln_travel);
        lnRestaurant = (LinearLayout) findViewById(R.id.ln_restaurant);
        lnHotel = (LinearLayout) findViewById(R.id.ln_hotel);
        lnTravelDetail = (LinearLayout) findViewById(R.id.ln_travel_detail);
        lnRestaurantDetail = (LinearLayout) findViewById(R.id.ln_restaurant_detail);
        lnHotelDetail = (LinearLayout) findViewById(R.id.ln_hotel_detail);
        lnCatAlam = (LinearLayout) findViewById(R.id.ln_cat_alam);
        lnCatBuatan = (LinearLayout) findViewById(R.id.ln_cat_buatan);
        lnWisataDate = (LinearLayout) findViewById(R.id.ln_wisata_date);
        lnKulinerDate = (LinearLayout) findViewById(R.id.ln_kuliner_date);
        lnCheckInDate = (LinearLayout) findViewById(R.id.ln_checkin_date);
        lnCheckOutDate = (LinearLayout) findViewById(R.id.ln_checkout_date);

        imgIcTravel = (ImageView) findViewById(R.id.img_travel_ic);
        imgIcRestaurant = (ImageView) findViewById(R.id.img_restaurant_ic);
        imgIcHotel = (ImageView) findViewById(R.id.img_hotel_ic);
        imgCatAlam = (ImageView) findViewById(R.id.img_cat_alam);
        imgCatBuatan = (ImageView) findViewById(R.id.img_cat_buatan);

        rvTravelling = (RelativeLayout) findViewById(R.id.rv_travelling);
        rvMotorMin = (RelativeLayout) findViewById(R.id.rv_motor_min);
        rvMotorPlus = (RelativeLayout) findViewById(R.id.rv_motor_plus);
        rvCarMin = (RelativeLayout) findViewById(R.id.rv_car_min);
        rvCarPlus = (RelativeLayout) findViewById(R.id.rv_car_plus);
        rvBusMin = (RelativeLayout) findViewById(R.id.rv_bus_min);
        rvBusPlus = (RelativeLayout) findViewById(R.id.rv_bus_plus);
        rvAdultMin = (RelativeLayout) findViewById(R.id.rv_adult_min);
        rvAdultPlus = (RelativeLayout) findViewById(R.id.rv_adult_plus);
        rvChildMin = (RelativeLayout) findViewById(R.id.rv_child_min);
        rvChildPlus = (RelativeLayout) findViewById(R.id.rv_child_plus);
        rvPorsiMin = (RelativeLayout) findViewById(R.id.rv_porsi_min);
        rvPorsiPlus = (RelativeLayout) findViewById(R.id.rv_porsi_plus);
        rvKamarMin = (RelativeLayout) findViewById(R.id.rv_kamar_min);
        rvKamarPlus = (RelativeLayout) findViewById(R.id.rv_kamar_plus);

        rvMotorMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ticketMotor > 0) ticketMotor--;
                tvMotor.setText(String.valueOf(ticketMotor));
            }
        });

        rvMotorPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ticketMotor++;
                tvMotor.setText(String.valueOf(ticketMotor));
            }
        });

        rvCarMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ticketCar > 0) ticketCar--;
                tvCar.setText(String.valueOf(ticketCar));
            }
        });

        rvCarPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ticketCar++;
                tvCar.setText(String.valueOf(ticketCar));
            }
        });

        rvBusMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ticketBus > 0) ticketBus--;
                tvBus.setText(String.valueOf(ticketBus));
            }
        });

        rvBusPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ticketBus++;
                tvBus.setText(String.valueOf(ticketBus));
            }
        });

        rvAdultMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ticketAdult > 0) ticketAdult--;
                tvAdult.setText(String.valueOf(ticketAdult));
            }
        });

        rvAdultPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ticketAdult++;
                tvAdult.setText(String.valueOf(ticketAdult));
            }
        });

        rvChildMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ticketChild > 0) ticketChild--;
                tvChild.setText(String.valueOf(ticketChild));
            }
        });

        rvChildPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ticketChild++;
                tvChild.setText(String.valueOf(ticketChild));
            }
        });

        rvPorsiMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (jumPorsi > 0) jumPorsi--;
                tvPorsi.setText(String.valueOf(jumPorsi));
            }
        });

        rvPorsiPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumPorsi++;
                tvPorsi.setText(String.valueOf(jumPorsi));
            }
        });

        rvKamarMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (jumKamar > 0) jumKamar--;
                tvKamar.setText(String.valueOf(jumKamar));
            }
        });

        rvKamarPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumKamar++;
                tvKamar.setText(String.valueOf(jumKamar));
            }
        });

        lnCatAlam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!categoryWisata.contains("alam")) {
                    categoryWisata.add("alam");
                    lnCatAlam.setBackgroundResource(R.drawable.ic_reg_gradient);
                    tvCatAlam.setTextColor(Color.parseColor("#FFFFFF"));
                    imgCatAlam.setImageTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));
                } else {
                    categoryWisata.remove("alam");
                    lnCatAlam.setBackgroundResource(R.drawable.ic_reg_white);
                    tvCatAlam.setTextColor(Color.parseColor("#656565"));
                    imgCatAlam.setImageTintList(ColorStateList.valueOf(Color.parseColor("#656565")));
                }
                Toast.makeText(LetsActivity.this, categoryWisata.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        lnCatBuatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!categoryWisata.contains("buatan")) {
                    categoryWisata.add("buatan");
                    lnCatBuatan.setBackgroundResource(R.drawable.ic_reg_gradient);
                    tvCatBuatan.setTextColor(Color.parseColor("#FFFFFF"));
                    imgCatBuatan.setImageTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));
                } else {
                    categoryWisata.remove("buatan");
                    lnCatBuatan.setBackgroundResource(R.drawable.ic_reg_white);
                    tvCatBuatan.setTextColor(Color.parseColor("#656565"));
                    imgCatBuatan.setImageTintList(ColorStateList.valueOf(Color.parseColor("#656565")));
                }
                Toast.makeText(LetsActivity.this, categoryWisata.toString(), Toast.LENGTH_SHORT).show();
            }
        });

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
