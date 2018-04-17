package com.pens.travelme.travelme.frag_lets.recommend.recommend_hotel;

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
import com.pens.travelme.travelme.modal.Kamar;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static com.pens.travelme.travelme.frag_lets.recommend.recommend_hotel.ReHotelFragment.REHOTEL_FRAG_TAG;

/**
 * Created by afdol on 4/10/2018.
 */

public class ReHotelAdapter extends RecyclerView.Adapter<ReHotelAdapter.MyViewHolder> {

    private Context context;
    private List<Kamar> hotels;
    private int room;

    public ReHotelAdapter(Context context, List<Kamar> hotels, int room) {
        this.context = context;
        this.hotels = hotels;
        this.room = room;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_travel, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Kamar kamar = hotels.get(position);

//        holder.imgItem.setImageResource(kamar.getImage());
        holder.tvTitle.setText(kamar.getNama());
        holder.tvAddress.setText(getAddress(new LatLng(kamar.getPenginapan().getPosisi_lat(), kamar.getPenginapan().getPosisi_lng())));
        holder.tvPrice.setText("Rp "+ kamar.getHarga() * room);
        holder.tvDetailPrice.setText("Jumlah kamar : "+ room +"\nHarga kamar : "+ kamar.getHarga());
        holder.tvTime.setVisibility(View.GONE);

        holder.imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + kamar.getPenginapan().getNo_telp()));
                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return hotels.size();
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
            Log.e(REHOTEL_FRAG_TAG, e.getMessage());
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
