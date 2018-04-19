package com.pens.travelme.travelme.frag_lets.recommend.recommend_restaurant;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
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
import com.pens.travelme.travelme.actv_detail.DetailKulinerActivity;
import com.pens.travelme.travelme.modal.Menu;
import com.pens.travelme.travelme.modal.MyChoice;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static com.pens.travelme.travelme.actv_detail.DetailKulinerActivity.KULINER_ID;
import static com.pens.travelme.travelme.frag_home.HomeFragment.HOME_FRAG_TAG;
import static com.pens.travelme.travelme.frag_lets.recommend.recommend_restaurant.ReRestaurantFragment.RERESTO_FRAG_TAG;

/**
 * Created by afdol on 4/10/2018.
 */

public class ReRestaurantAdapter extends RecyclerView.Adapter<ReRestaurantAdapter.MyViewHolder> {

    private Context context;
    private List<Menu> menus;
    private MyChoice myChoice;

    public ReRestaurantAdapter(Context context, List<Menu> menus, MyChoice myChoice) {
        this.context = context;
        this.menus = menus;
        this.myChoice = myChoice;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_travel, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Menu menu = menus.get(position);
        final Double totalHarga = menu.getHarga() * myChoice.getJumPorsi();

//        holder.imgDrink.setImageResource(menu.getDrinks().get(0).getImage());
//        holder.imgFood.setImageResource(menu.getFoods().get(0).getImage());

        holder.tvTitle.setText(menu.getNama());
        holder.tvPrice.setText("Rp "+ totalHarga);
        holder.tvDetailPrice.setText("Jumlah porsi : "+ myChoice.getJumPorsi() +"\nHarga per porsi : "+ menu.getHarga());
        holder.tvTime.setText(menu.getKuliner().getJam_buka() +" wib - "+ menu.getKuliner().getJam_tutup() +" wib");

        holder.cardItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailKulinerActivity.class);
                intent.putExtra(KULINER_ID, menu.getId_kuliner());
                context.startActivity(intent);
            }
        });

        holder.imgCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences = ((Activity)context).getSharedPreferences("myTravel",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();


                if(sharedPreferences.getString("id_menu","").contains(","+String.valueOf(menu.getId_menu()))){
                    holder.imgCheck.setImageTintList(ColorStateList.valueOf(Color.parseColor("#D5D5D5")));
                    myChoice.setBudget(myChoice.getBudget()+totalHarga);

                    String add_menu = sharedPreferences.getString("id_menu","");
                    add_menu = add_menu.replace(","+String.valueOf(menu.getId_menu()),"");
                    editor.putString("id_menu", String.valueOf(add_menu));
                    editor.commit();
                }
                else {
                    if (totalHarga>myChoice.getBudget()){
                        Toast.makeText(context, "Budget anda tidak cukup", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        holder.imgCheck.setImageTintList(ColorStateList.valueOf(Color.parseColor("#000000")));

                        myChoice.setBudget(myChoice.getBudget()-totalHarga);

                        String add_menu = sharedPreferences.getString("id_menu","")+","+menu.getId_menu();
                        editor.putString("id_menu", String.valueOf(add_menu));
                        editor.commit();
                    }
                }

                Log.d("selectedMenu",sharedPreferences.getString("id_menu",""));
                Log.d("budget", String.valueOf(myChoice.getBudget()));


            }
        });

        holder.imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + menu.getKuliner().getNo_telp()));
                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    context.startActivity(intent);
                }
            }
        });

        Glide.with(context)
                .load(menu.getFoto())
                .into(holder.imgItem);

        Geocoder geocoder = new Geocoder(context, Locale.ENGLISH);
        try {
            List<Address> addresses = geocoder.getFromLocation(menu.getKuliner().getPosisi_lat(), menu.getKuliner().getPosisi_lng(), 1);

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
        return menus.size();
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
