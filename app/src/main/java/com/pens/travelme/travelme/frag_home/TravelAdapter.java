package com.pens.travelme.travelme.frag_home;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pens.travelme.travelme.R;
<<<<<<< HEAD:app/src/main/java/com/pens/travelme/travelme/frag_home/TravelAdapter.java
import com.pens.travelme.travelme.modal.Travel;
=======
>>>>>>> uki:app/src/main/java/com/pens/travelme/travelme/home/TravelAdapter.java

import java.util.List;

/**
 * Created by afdol on 4/10/2018.
 */

public class TravelAdapter extends RecyclerView.Adapter<TravelAdapter.MyViewHolder> {
    private Context context;
    private List<Travel> travels;

    public TravelAdapter(Context context, List<Travel> travels) {
        this.context = context;
        this.travels = travels;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Travel travel = travels.get(position);

        holder.imgItem.setImageResource(travel.getImage());
        holder.tvTitle.setText(travel.getTitle());
        holder.tvAddress.setText(travel.getAddress());
    }

    @Override
    public int getItemCount() {
        return travels.size();
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
