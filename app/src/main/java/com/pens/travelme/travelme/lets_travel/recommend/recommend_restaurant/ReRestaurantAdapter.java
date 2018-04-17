package com.pens.travelme.travelme.lets_travel.recommend.recommend_restaurant;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pens.travelme.travelme.R;

import java.util.List;

/**
 * Created by afdol on 4/10/2018.
 */

public class ReRestaurantAdapter extends RecyclerView.Adapter<ReRestaurantAdapter.MyViewHolder> {

    private Context context;
    private List<Restaurant> restaurants;

    public ReRestaurantAdapter(Context context, List<Restaurant> restaurants) {
        this.context = context;
        this.restaurants = restaurants;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Restaurant restaurant = restaurants.get(position);

        int priceFood = Integer.parseInt(restaurant.getFoods().get(0).getPrice());
        int priceDrink = Integer.parseInt(restaurant.getDrinks().get(0).getPrice());
        int totalPrice = priceDrink + priceFood;

        holder.imgDrink.setImageResource(restaurant.getDrinks().get(0).getImage());
        holder.imgFood.setImageResource(restaurant.getFoods().get(0).getImage());

        holder.tvTitle.setText(restaurant.getTitle());
        holder.tvAddress.setText(restaurant.getAddress());
        holder.tvPrice.setText(String.valueOf(totalPrice));
        holder.tvTitleFood.setText(restaurant.getFoods().get(0).getTitle());
        holder.tvTitleDrink.setText(restaurant.getDrinks().get(0).getTitle());
        holder.tvPriceFood.setText(restaurant.getFoods().get(0).getPrice());
        holder.tvPriceDrink.setText(restaurant.getDrinks().get(0).getPrice());

        holder.imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + restaurant.getPhone()));
                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private CardView cardItem;
        private ImageView imgFood, imgDrink, imgCall, imgCheck;
        private TextView tvTitle, tvAddress, tvTitleFood, tvTitleDrink, tvPriceFood, tvPriceDrink, tvPrice;


        public MyViewHolder(View itemView) {
            super(itemView);

            cardItem = (CardView) itemView.findViewById(R.id.card_item);
            imgFood = (ImageView) itemView.findViewById(R.id.img_food);
            imgDrink = (ImageView) itemView.findViewById(R.id.img_drink);
            imgCall = (ImageView) itemView.findViewById(R.id.img_call);
            imgCheck = (ImageView) itemView.findViewById(R.id.img_check);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvAddress = (TextView) itemView.findViewById(R.id.tv_address);
            tvPrice = (TextView) itemView.findViewById(R.id.tv_price);
            tvTitleFood = (TextView) itemView.findViewById(R.id.tv_title_food);
            tvTitleDrink = (TextView) itemView.findViewById(R.id.tv_title_drink);
            tvPriceFood = (TextView) itemView.findViewById(R.id.tv_price_food);
            tvPriceDrink = (TextView) itemView.findViewById(R.id.tv_price_drink);
        }
    }
}
