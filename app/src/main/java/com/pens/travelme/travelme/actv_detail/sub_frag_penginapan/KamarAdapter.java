package com.pens.travelme.travelme.actv_detail.sub_frag_penginapan;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pens.travelme.travelme.R;
import com.pens.travelme.travelme.actv_detail.DetailKamarActivity;
import com.pens.travelme.travelme.modal.Kamar;

import java.util.List;

import static com.pens.travelme.travelme.actv_detail.DetailKamarActivity.KAMAR_ID;

/**
 * Created by afdol on 4/19/2018.
 */

public class KamarAdapter extends RecyclerView.Adapter<KamarAdapter.MyViewHolder> {

    private Context context;
    private List<Kamar> kamars;

    public KamarAdapter(Context context, List<Kamar> kamars) {
        this.context = context;
        this.kamars = kamars;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Kamar kamar = kamars.get(position);

        Glide.with(context)
                .load(kamar.getFoto())
                .into(holder.imgItem);

        holder.tvTitle.setText(kamar.getNama());
        holder.tvPrice.setText("Rp "+ kamar.getHarga());
        holder.cardItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailKamarActivity.class);
                intent.putExtra(KAMAR_ID, kamar.getId_kamar());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return kamars.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private CardView cardItem;
        private ImageView imgItem;
        private TextView tvTitle, tvPrice;

        public MyViewHolder(View itemView) {
            super(itemView);

            cardItem = (CardView) itemView.findViewById(R.id.card_view);
            imgItem = (ImageView) itemView.findViewById(R.id.img_item);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvPrice = (TextView) itemView.findViewById(R.id.tv_price);
        }
    }
}