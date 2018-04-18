package com.pens.travelme.travelme.frag_lets.recommend.recommend_travel;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.model.LatLng;
import com.pens.travelme.travelme.R;
import com.pens.travelme.travelme.modal.Wisata;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static com.pens.travelme.travelme.frag_home.HomeFragment.HOME_FRAG_TAG;
import static com.pens.travelme.travelme.frag_lets.recommend.recommend_restaurant.ReRestaurantFragment.RERESTO_FRAG_TAG;
import static com.pens.travelme.travelme.frag_lets.recommend.recommend_travel.ReTravelFragment.RETRAVEL_FRAG_TAG;

/**
 * Created by afdol on 4/10/2018.
 */

public class ReTravelAdapter extends RecyclerView.Adapter<ReTravelAdapter.MyViewHolder> {
    private Context context;
    private List<Wisata> travels;
    private int motor, car, bus, adult, child;

    public ReTravelAdapter(Context context, List<Wisata> travels, int motor, int car, int bus, int adult, int child) {
        this.context = context;
        this.travels = travels;
        this.motor = motor;
        this.car = car;
        this.bus = bus;
        this.adult = adult;
        this.child = child;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_travel, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Wisata wisata = travels.get(position);

        Double totalHarga = motor * wisata.getBiaya_parkir_motor() + car * wisata.getBiaya_parkir_mobil() + bus * wisata.getBiaya_parkir_bus() + adult * wisata.getTiket_masuk_dewasa() + child * wisata.getTiket_masuk_anak();

        String detailPrice = null;
        if (adult != 0) { detailPrice = "Tiket dewasa : "+ wisata.getTiket_masuk_dewasa().toString() +" x "+ adult +" = "+ adult * wisata.getTiket_masuk_dewasa(); }
        if (child != 0 && adult != 0) {
            detailPrice += "\nTiket anak : "+ wisata.getTiket_masuk_anak().toString() +" x "+ child +" = "+ child * wisata.getTiket_masuk_anak();
        } else if (child != 0) {
            detailPrice = "Tiket anak : "+ wisata.getTiket_masuk_anak().toString() +" x "+ child +" = "+ child * wisata.getTiket_masuk_anak();
        }
        if (motor != 0) { detailPrice +="\nParkir motor : "+ wisata.getBiaya_parkir_motor() +" x "+ motor +" = "+ motor * wisata.getBiaya_parkir_motor(); }
        if (car != 0) { detailPrice +="\nParkir mobil : "+ wisata.getBiaya_parkir_mobil() +" x "+ car +" = "+ car * wisata.getBiaya_parkir_mobil(); }
        if (bus != 0) { detailPrice +="\nParkir bus : "+ wisata.getBiaya_parkir_bus() +" x "+ bus +" = "+ bus * wisata.getBiaya_parkir_bus(); }


//        holder.imgItem.setImageResource(wisata.getFoto());
        holder.tvTitle.setText(wisata.getNama());
        holder.tvPrice.setText("Rp "+ totalHarga.toString());
        holder.tvDetailPrice.setText(detailPrice);
        holder.tvTime.setText(wisata.getJam_buka() +" wib - "+ wisata.getJam_tutup() +" wib");
        holder.imgCall.setVisibility(View.GONE);

        Glide.with(context)
                .load(wisata.getFoto())
                .into(holder.imgItem);

        Geocoder geocoder = new Geocoder(context, Locale.ENGLISH);
        try {
            List<Address> addresses = geocoder.getFromLocation(wisata.getPosisi_lat(), wisata.getPosisi_lng(), 1);

            if (addresses.size() > 0) {
                Address fetchedAddress = addresses.get(0);
                holder.tvAddress.setText(fetchedAddress.getAddressLine(0));
            } else {
                holder.tvAddress.setText("-");
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(HOME_FRAG_TAG, e.getMessage());
            holder.tvAddress.setText("-");
        }
    }

    @Override
    public int getItemCount() {
        return travels.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private CardView cardItem;
        private ImageView imgItem, imgCall, imgCheck;
        private TextView tvTitle, tvAddress, tvPrice, tvDetailPrice, tvTime;

        public MyViewHolder(View itemView) {
            super(itemView);

            cardItem = (CardView) itemView.findViewById(R.id.card_item);
            imgItem = (ImageView) itemView.findViewById(R.id.img_item);
            imgCall = (ImageView) itemView.findViewById(R.id.img_call);
            imgCheck = (ImageView) itemView.findViewById(R.id.img_check);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvAddress = (TextView) itemView.findViewById(R.id.tv_address);
            tvPrice = (TextView) itemView.findViewById(R.id.tv_price);
            tvDetailPrice = (TextView) itemView.findViewById(R.id.tv_detail_price);
            tvTime = (TextView) itemView.findViewById(R.id.tv_time);
        }
    }
}
