package com.pens.travelme.travelme.lets_travel.recommend.recommend_restaurant;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pens.travelme.travelme.R;
import com.pens.travelme.travelme.modal.Restaurant;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReRestaurantFragment extends Fragment {

    private RecyclerView rcRestaurant;
    private List<Restaurant> restaurants = new ArrayList<>();

    public ReRestaurantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_re_restaurant, container, false);

        rcRestaurant = (RecyclerView) view.findViewById(R.id.rc_restaurant);

        RecyclerView.LayoutManager travelLayout = new LinearLayoutManager(getContext());
        rcRestaurant.setLayoutManager(travelLayout);
        rcRestaurant.setItemAnimator(new DefaultItemAnimator());
        rcRestaurant.setAdapter(new ReRestaurantAdapter(getContext(), restaurants));
        rcRestaurant.setFocusable(false);

        loadRestaurantData();

        return view;
    }

    public void loadRestaurantData() {
        List<Restaurant.Food> foods = new ArrayList<>();
        Restaurant.Food food = new Restaurant.Food(
                "Beef Steak",
                "125000",
                R.drawable.food
        );
        foods.add(food);


        List<Restaurant.Drink> drinks = new ArrayList<>();
        Restaurant.Drink drink = new Restaurant.Drink(
                "Sweet Tea",
                "25000",
                R.drawable.drink
        );
        drinks.add(drink);


        Restaurant restaurant = new Restaurant(
                "Jepun View Resto",
                "Jl. Mayor Sujadi Jepun, Jepun, Kec. Tulungagung, Kabupaten Tulungagung",
                "08124078773",
                R.drawable.resto1,
                foods,
                drinks
        );
        restaurants.add(restaurant);

        restaurant = new Restaurant(
                "D'Oeleg Resto & Café",
                "Jl. Raya Jemursari No. 167 Surabaya",
                "0318418430",
                R.drawable.resto2,
                foods,
                drinks
        );
        restaurants.add(restaurant);

        restaurant = new Restaurant(
                "Bakso Solo Rindu Malam",
                "Jl. Ciliwung No. 123 Surabaya",
                "082233993089",
                R.drawable.resto3,
                foods,
                drinks
        );
        restaurants.add(restaurant);

        restaurant = new Restaurant(
                "Bakso Hitam",
                "Jl. Pandegiling No. 244 Surabaya",
                "082216698639",
                R.drawable.resto4,
                foods,
                drinks
        );
        restaurants.add(restaurant);

        restaurant = new Restaurant(
                "Rumah Makan Forum",
                "Jl. Margorejo Indah No. 128-130 Surabaya",
                "0318436300",
                R.drawable.resto5,
                foods,
                drinks
        );
        restaurants.add(restaurant);

        rcRestaurant.getAdapter().notifyDataSetChanged();
    }

}
