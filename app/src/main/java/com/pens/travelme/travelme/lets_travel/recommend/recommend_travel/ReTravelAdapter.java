package com.pens.travelme.travelme.lets_travel.recommend.recommend_travel;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
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
import com.pens.travelme.travelme.modal.Travel;

import java.util.List;

/**
 * Created by afdol on 4/10/2018.
 */

public class ReTravelAdapter extends RecyclerView.Adapter<ReTravelAdapter.MyViewHolder> {
    private Context context;
    private List<Travel> travels;

    public ReTravelAdapter(Context context, List<Travel> travels) {
        this.context = context;
        this.travels = travels;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_travel, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Travel travel = travels.get(position);

        holder.imgItem.setImageResource(travel.getImage());
        holder.tvTitle.setText(travel.getTitle());
        holder.tvAddress.setText(travel.getAddress());
        holder.tvPrice.setText(travel.getPrice());

        holder.imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + travel.getPhone()));
                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return travels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private CardView cardItem;
        private ImageView imgItem, imgCall, imgCheck;
        private TextView tvTitle, tvAddress, tvPrice;

        public MyViewHolder(View itemView) {
            super(itemView);

            cardItem = (CardView) itemView.findViewById(R.id.card_item);
            imgItem = (ImageView) itemView.findViewById(R.id.img_item);
            imgCall = (ImageView) itemView.findViewById(R.id.img_call);
            imgCheck = (ImageView) itemView.findViewById(R.id.img_check);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvAddress = (TextView) itemView.findViewById(R.id.tv_address);
            tvPrice = (TextView) itemView.findViewById(R.id.tv_price);
        }
    }
}
