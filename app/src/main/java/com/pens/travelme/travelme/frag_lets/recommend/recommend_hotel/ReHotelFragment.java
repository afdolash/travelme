package com.pens.travelme.travelme.frag_lets.recommend.recommend_hotel;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pens.travelme.travelme.R;
import com.pens.travelme.travelme.modal.Hotel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReHotelFragment extends Fragment {

    private RecyclerView rcHotel;
    private List<Hotel> hotels = new ArrayList<>();

    public ReHotelFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_re_hotel, container, false);

        rcHotel = (RecyclerView) view.findViewById(R.id.rc_hotel);

        RecyclerView.LayoutManager travelLayout = new LinearLayoutManager(getContext());
        rcHotel.setLayoutManager(travelLayout);
        rcHotel.setItemAnimator(new DefaultItemAnimator());
        rcHotel.setAdapter(new ReHotelAdapter(getContext(), hotels));
        rcHotel.setFocusable(false);

        loadHotelData();

        return view;
    }

    public void loadHotelData() {
        Hotel hotel = new Hotel(
                "Swiss-Belinn",
                "Jl. Manyar Kertoarjo No.100, Manyar Sabrangan, Mulyorejo, Kota Surabaya",
                "585714",
                "0315946868",
                R.drawable.hotel1
        );
        hotels.add(hotel);

        hotel = new Hotel(
                "Hotel Gunawangsa",
                "Raya Kedung Baruk No.96, Kedung Baruk, Rungkut, Kota Surabaya",
                "410086",
                "0318700766",
                R.drawable.hotel2
        );
        hotels.add(hotel);

        hotel = new Hotel(
                "Narita Hotel",
                "Jl. Barata Jaya XVII No.57-59, Baratajaya, Gubeng, Kota Surabaya",
                "421857",
                "0315016969",
                R.drawable.hotel1
        );
        hotels.add(hotel);

        hotel = new Hotel(
                "Grace Setia Hotel",
                "Jl. Dokter Ir. H. Soekarno Km. 158 No. 47, Kalijudan, Mulyorejo, Kalijudan, Mulyorejo, Kota Surabaya",
                "230150",
                "0313810300",
                R.drawable.hotel4
        );
        hotels.add(hotel);

        hotel = new Hotel(
                "Everbright Hotel",
                "Jalan Manyar Kertoarjo No.44, Manyar Sabrangan, Mulyorejo, Manyar Sabrangan, Mulyorejo, Kota Surabaya",
                "362660",
                "0315967400",
                R.drawable.hotel5
        );
        hotels.add(hotel);

        rcHotel.getAdapter().notifyDataSetChanged();
    }
}
