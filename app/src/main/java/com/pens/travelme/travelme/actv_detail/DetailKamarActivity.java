package com.pens.travelme.travelme.actv_detail;

import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pens.travelme.travelme.R;
import com.pens.travelme.travelme.api.ApiServices;
import com.pens.travelme.travelme.modal.Kamar;
import com.pens.travelme.travelme.modal.Penginapan;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailKamarActivity extends AppCompatActivity {
    public static final String KAMAR_ID = "kamar_id";

    private int kamarId;
    private Kamar kamar;
    private Penginapan penginapan;

    private ImageView imgDetail;
    private TextView tvTitle, tvAddress, tvPrice, tvFacilities, tvRooms, tvCapacity, tvHotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kamar);

        kamarId = getIntent().getIntExtra(KAMAR_ID, 0);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        imgDetail = (ImageView) findViewById(R.id.img_detail);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvHotel = (TextView) findViewById(R.id.tv_hotel);
        tvAddress = (TextView) findViewById(R.id.tv_address);
        tvRooms = (TextView) findViewById(R.id.tv_rooms);
        tvCapacity = (TextView) findViewById(R.id.tv_capacity);
        tvPrice = (TextView) findViewById(R.id.tv_price);
        tvFacilities = (TextView) findViewById(R.id.tv_facilities);

        loadKamarData();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    public void loadKamarData() {
        ApiServices.service_post.get_detail_kamar(kamarId).enqueue(new Callback<Kamar>() {
            @Override
            public void onResponse(Call<Kamar> call, Response<Kamar> response) {
                kamar = response.body();
                loadPenginapanData();
            }

            @Override
            public void onFailure(Call<Kamar> call, Throwable t) {
                Log.d("DetailKamarActivity", t.getMessage());
            }
        });
    }

    public void loadPenginapanData() {
        ApiServices.service_post.get_detail_penginapan(kamar.getId_penginapan()).enqueue(new Callback<Penginapan>() {
            @Override
            public void onResponse(Call<Penginapan> call, Response<Penginapan> response) {
                penginapan = response.body();
                setKamarView();
            }

            @Override
            public void onFailure(Call<Penginapan> call, Throwable t) {
                Log.d("DetailKamarActivity", t.getMessage());
            }
        });
    }

    public void setKamarView() {
        Glide.with(this)
                .load(kamar.getFoto())
                .into(imgDetail);

        Geocoder geocoder = new Geocoder(this, Locale.ENGLISH);
        try {
            List<Address> addresses = geocoder.getFromLocation(penginapan.getPosisi_lat(), penginapan.getPosisi_lng(), 1);

            if (addresses.size() > 0) {
                Address fetchedAddress = addresses.get(0);
                tvAddress.setText(fetchedAddress.getAddressLine(0));
            } else {
                tvAddress.setText("-");
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("DetailKamarActivity", e.getMessage());
            tvAddress.setText("-");
        }

        tvTitle.setText(kamar.getNama());
        tvHotel.setText(penginapan.getNama());
        tvRooms.setText(String.valueOf(kamar.getBanyak_kamar()));
        tvCapacity.setText(String.valueOf(kamar.getKapasitas()));
        tvPrice.setText(String.valueOf(kamar.getHarga()));
        tvFacilities.setText(kamar.getFasilitas());
    }
}
