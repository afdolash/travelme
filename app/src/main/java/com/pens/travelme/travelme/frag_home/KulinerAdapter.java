package com.pens.travelme.travelme.frag_home;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
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
import com.pens.travelme.travelme.modal.Kuliner;
import com.pens.travelme.travelme.modal.Menu;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static com.pens.travelme.travelme.frag_home.HomeFragment.HOME_FRAG_TAG;

/**
 * Created by afdol on 4/10/2018.
 */

public class KulinerAdapter extends RecyclerView.Adapter<KulinerAdapter.MyViewHolder> {

    private Context context;
    private List<Kuliner> restaurants;

    public KulinerAdapter(Context context, List<Kuliner> restaurants) {
        this.context = context;
        this.restaurants = restaurants;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(KulinerAdapter.MyViewHolder holder, int position) {
        Kuliner kuliner = restaurants.get(position);

//        holder.imgItem.setImageResource(kuliner.getFoto());
        holder.tvTitle.setText(kuliner.getNama());
        holder.tvAddress.setText(getAddress(new LatLng(kuliner.getPosisi_lat(), kuliner.getPosisi_lng())));
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
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
            Log.e(HOME_FRAG_TAG, e.getMessage());
        }
        return "-";
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private CardView cardItem;
        private ImageView imgItem;
        private TextView tvTitle, tvAddress;

        public MyViewHolder(View itemView) {
            super(itemView);

            cardItem = (CardView) itemView.findViewById(R.id.card_item);
            imgItem = (ImageView) itemView.findViewById(R.id.img_item);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvAddress = (TextView) itemView.findViewById(R.id.tv_address);
        }
    }
}
