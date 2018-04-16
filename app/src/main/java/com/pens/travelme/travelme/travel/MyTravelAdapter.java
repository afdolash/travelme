package com.pens.travelme.travelme.travel;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pens.travelme.travelme.R;
import com.pens.travelme.travelme.modal.Travel;

import java.util.List;


/**
 * Created by afdol on 4/10/2018.
 */

public class MyTravelAdapter extends RecyclerView.Adapter<MyTravelAdapter.MyViewHolder> {

    private Context context;
    private List<MyTravel> myTravels;

    public MyTravelAdapter(Context context, List<MyTravel> myTravels) {
        this.context = context;
        this.myTravels = myTravels;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mytravel, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MyTravel myTravel = myTravels.get(position);

        holder.tvDate.setText(myTravel.getDate());
        holder.tvTitle.setText(myTravel.getTitle());
        holder.tvTitleTravel.setText(myTravel.getTravel().getTitle());
        holder.tvAddressTravel.setText(myTravel.getTravel().getAddress());
        holder.imgTravel.setImageResource(myTravel.getTravel().getImage());
        holder.tvTitleHotel.setText(myTravel.getHotel().getTitle());
        holder.tvAddressHotel.setText(myTravel.getHotel().getAddress());
        holder.imgHotel.setImageResource(myTravel.getHotel().getImage());
        holder.tvTitleRestaurant.setText(myTravel.getRestaurant().getTitle());
        holder.tvAddressRestaurant.setText(myTravel.getRestaurant().getAddress());
        holder.imgRestaurant.setImageResource(myTravel.getRestaurant().getImage());
    }

    @Override
    public int getItemCount() {
        return myTravels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvDate, tvTitle;
        private TextView tvTitleTravel, tvTitleHotel, tvTitleRestaurant;
        private TextView tvAddressTravel, tvAddressHotel, tvAddressRestaurant;
        private ImageView imgTravel, imgHotel, imgRestaurant;
        private CardView cardTravel, cardHotel, cardRestaurant;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvDate = (TextView) itemView.findViewById(R.id.tv_date);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvTitleTravel = (TextView) itemView.findViewById(R.id.tv_title_travel);
            tvTitleHotel = (TextView) itemView.findViewById(R.id.tv_title_hotel);
            tvTitleRestaurant = (TextView) itemView.findViewById(R.id.tv_title_restaurant);
            tvAddressTravel = (TextView) itemView.findViewById(R.id.tv_address_travel);
            tvAddressHotel = (TextView) itemView.findViewById(R.id.tv_address_hotel);
            tvAddressRestaurant = (TextView) itemView.findViewById(R.id.tv_address_restaurant);
            imgTravel = (ImageView) itemView.findViewById(R.id.img_travel);
            imgHotel = (ImageView) itemView.findViewById(R.id.img_hotel);
            imgRestaurant = (ImageView) itemView.findViewById(R.id.img_restaurant);
            cardTravel = (CardView) itemView.findViewById(R.id.card_travel);
            cardHotel = (CardView) itemView.findViewById(R.id.card_hotel);
            cardRestaurant = (CardView) itemView.findViewById(R.id.card_restaurant);

        }
    }
}
