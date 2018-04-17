package com.pens.travelme.travelme.frag_travel;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pens.travelme.travelme.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TravelFragment extends Fragment {

    private RecyclerView rcMytravel;
    private List<MyTravel> myTravels = new ArrayList<>();

    public TravelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_travel, container, false);

        rcMytravel = (RecyclerView) view.findViewById(R.id.rc_mytravel);

        RecyclerView.LayoutManager mytravelLayout = new LinearLayoutManager(getContext());
        rcMytravel.setLayoutManager(mytravelLayout);
        rcMytravel.setItemAnimator(new DefaultItemAnimator());
        rcMytravel.setAdapter(new MyTravelAdapter(getContext(), myTravels));

//        loadMyTravelData();

        return view;
    }

//    public void loadMyTravelData() {
//        Travel travel = new Travel(
//                "Pantai Sanggar",
//                "Desa Karangasem, Kecamatan Kalidawir, Kabupaten Tulungagung",
//                "200000",
//                "08124078773",
//                R.drawable.travel3
//        );
//
//        List<Restaurant.Food> foods = new ArrayList<>();
//        Restaurant.Food food = new Restaurant.Food(
//                "Beef Steak",
//                "125000",
//                R.drawable.food
//        );
//        foods.add(food);
//
//
//        List<Restaurant.Drink> drinks = new ArrayList<>();
//        Restaurant.Drink drink = new Restaurant.Drink(
//                "Sweet Tea",
//                "25000",
//                R.drawable.drink
//        );
//        drinks.add(drink);
//
//
//        Restaurant restaurant = new Restaurant(
//                "Jepun View Resto",
//                "Jl. Mayor Sujadi Jepun, Jepun, Kec. Tulungagung, Kabupaten Tulungagung",
//                "08124078773",
//                R.drawable.resto1,
//                foods,
//                drinks
//        );
//
//        Hotel hotel = new Hotel(
//                "Crown Victoria Hotel",
//                "Jalan Supriadi No.41, Jepun, Kecamatan Tulungagung, Jepun, Kec. Tulungagung, Kabupaten Tulungagung",
//                "e00000",
//                "08124078773",
//                R.drawable.hotel1
//        );
//
//        MyTravel myTravel = new MyTravel(
//                "Selasa, 10 April 2018",
//                "My Travelling 1",
//                travel,
//                hotel,
//                restaurant
//        );
//        myTravels.add(myTravel);
//
//        rcMytravel.getAdapter().notifyDataSetChanged();
//    }

}
