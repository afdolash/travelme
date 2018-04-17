package com.pens.travelme.travelme.frag_lets.recommend.recommend_restaurant;

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

import com.google.android.gms.maps.model.LatLng;
import com.pens.travelme.travelme.R;
import com.pens.travelme.travelme.modal.Menu;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static com.pens.travelme.travelme.frag_lets.recommend.recommend_restaurant.ReRestaurantFragment.RERESTO_FRAG_TAG;

/**
 * Created by afdol on 4/10/2018.
 */

public class ReRestaurantAdapter extends RecyclerView.Adapter<ReRestaurantAdapter.MyViewHolder> {

    private Context context;
    private List<Menu> menus;
    private int porsi;

    public ReRestaurantAdapter(Context context, List<Menu> restaurants, int porsi) {
        this.context = context;
        this.menus = restaurants;
        this.porsi = porsi;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_travel, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Menu menu = menus.get(position);

//        holder.imgDrink.setImageResource(menu.getDrinks().get(0).getImage());
//        holder.imgFood.setImageResource(menu.getFoods().get(0).getImage());

        holder.tvTitle.setText(menu.getNama());
        holder.tvAddress.setText(getAddress(new LatLng(menu.getKuliner().getPosisi_lat(), menu.getKuliner().getPosisi_lng())));
        holder.tvPrice.setText("Rp "+ menu.getHarga() * porsi);
        holder.tvDetailPrice.setText("Jumlah porsi : "+ porsi +"\nHarga per porsi : "+ menu.getHarga());
        holder.tvTime.setText(menu.getKuliner().getJam_buka() +" wib - "+ menu.getKuliner().getJam_tutup() +" wib");

        holder.imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + menu.getKuliner().getNo_telp()));
                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }


    private String getAddress(LatLng latLng) {
        Geocoder geocoder = new Geocoder(context, Locale.ENGLISH);
        try {
            List<Address> addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);

            if (addresses.size() > 0) {
                Address fetchedAddress = addresses.get(0);
                return fetchedAddress.getAddressLine(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(RERESTO_FRAG_TAG, e.getMessage());
        }
        return "-";
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
