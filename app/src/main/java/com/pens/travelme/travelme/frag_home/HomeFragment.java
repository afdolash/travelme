package com.pens.travelme.travelme.frag_home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.pens.travelme.travelme.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private EditText etSearch;
    private RecyclerView rcTravel, rcRestaurant, rcHotel;

    private List<Travel> travels = new ArrayList<>();
    private List<Restaurant> restaurants = new ArrayList<>();
    private List<Hotel> hotels = new ArrayList<>();


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        etSearch = (EditText) view.findViewById(R.id.et_search);
        rcTravel = (RecyclerView) view.findViewById(R.id.rc_travel);
        rcRestaurant = (RecyclerView) view.findViewById(R.id.rc_restaurant);
        rcHotel = (RecyclerView) view.findViewById(R.id.rc_hotel);

        RecyclerView.LayoutManager travelLayout = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rcTravel.setLayoutManager(travelLayout);
        rcTravel.setItemAnimator(new DefaultItemAnimator());
        rcTravel.setAdapter(new TravelAdapter(getContext(), travels));

        RecyclerView.LayoutManager restaurantLayout = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rcRestaurant.setLayoutManager(restaurantLayout);
        rcRestaurant.setItemAnimator(new DefaultItemAnimator());
        rcRestaurant.setAdapter(new RestaurantAdapter(getContext(), restaurants));

        RecyclerView.LayoutManager hotelLayout = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rcHotel.setLayoutManager(hotelLayout);
        rcHotel.setItemAnimator(new DefaultItemAnimator());
        rcHotel.setAdapter(new HotelAdapter(getContext(), hotels));

        loadTravelData();
        loadRestaurantData();
        loadHotelData();

        return view;
    }

    public void loadTravelData() {
        Travel travel = new Travel(
                "Hutan Bambu",
                "Jalan Raya Marina Asri, Keputih, Sukolilo, Keputih, Sukolilo, Kota Surabaya",
                "5000",
                "03177633435",
                R.drawable.travel3
        );
        travels.add(travel);

        travel = new Travel(
                "Wisata Mangrove Gunung Anyar",
                "Jalan Medokan Sawah Timur, Segoro Tambak, Sedati, Medokan Ayu, Rungkut, Kabupaten Sidoarjo",
                "10000",
                "03177633900",
                R.drawable.travel4
        );
        travels.add(travel);

        travel = new Travel(
                "Wisata Pantai Kenjeran Lama",
                "Jl. Raya Pantai Lama No.12, Kenjeran, Bulak, Kota Surabaya",
                "8000",
                "03177633896",
                R.drawable.hotel1
        );
        travels.add(travel);

        travel = new Travel(
                "Monumen Kapal Selam",
                "Jalan Pemuda No.39, Embong Kaliasin, Genteng, Embong Kaliasin, Genteng, Kota Surabaya",
                "15000",
                "03177633776",
                R.drawable.hotel2
        );
        travels.add(travel);

        travel = new Travel(
                "Kebun Binatang Surabaya",
                "Jalan Setail No. 1, Darmo, Wonokromo, Kota Surabaya",
                "20000",
                "0317633666",
                R.drawable.travel3
        );
        travels.add(travel);

        rcTravel.getAdapter().notifyDataSetChanged();
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
