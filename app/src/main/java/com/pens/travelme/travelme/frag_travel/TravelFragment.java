package com.pens.travelme.travelme.frag_travel;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.common.AccountPicker;
import com.pens.travelme.travelme.R;
import com.pens.travelme.travelme.api.ApiServices;
import com.pens.travelme.travelme.frag_lets.recommend.RecommendActivity;
import com.pens.travelme.travelme.modal.Kamar;
import com.pens.travelme.travelme.modal.Menu;
import com.pens.travelme.travelme.modal.Packages;
import com.pens.travelme.travelme.modal.Wisata;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class TravelFragment extends Fragment {

    private RecyclerView rcTravel,rcHotel,rcRestaurant;
    private List<Wisata> travels = new ArrayList<>();
    private List<Kamar> hotels = new ArrayList<>();
    private List<Menu> menus = new ArrayList<>();
    private TextView tvMyBudget, tvTotalBudget;

    public TravelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_travel, container, false);


        SharedPreferences sharedPreferences = getContext().getSharedPreferences("myTravel", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        rcTravel = (RecyclerView) view.findViewById(R.id.rc_travel);
        RecyclerView.LayoutManager travelLayout = new LinearLayoutManager(getContext());
        rcTravel.setLayoutManager(travelLayout);
        rcTravel.setItemAnimator(new DefaultItemAnimator());
        rcTravel.setFocusable(false);

        rcHotel = (RecyclerView) view.findViewById(R.id.rc_hotel);
        RecyclerView.LayoutManager travelLayout1 = new LinearLayoutManager(getContext());
        rcHotel.setLayoutManager(travelLayout1);
        rcHotel.setItemAnimator(new DefaultItemAnimator());
        rcHotel.setFocusable(false);

        rcRestaurant = (RecyclerView) view.findViewById(R.id.rc_restaurant);
        RecyclerView.LayoutManager travelLayout2 = new LinearLayoutManager(getContext());
        rcRestaurant.setLayoutManager(travelLayout2);
        rcRestaurant.setItemAnimator(new DefaultItemAnimator());
        rcRestaurant.setFocusable(false);

        tvMyBudget = (TextView) view.findViewById(R.id.tv_my_budget);
        tvMyBudget.setText("Rp "+ sharedPreferences.getString("sisabudget",""));

        tvTotalBudget = (TextView) view.findViewById(R.id.tv_total_budget);
        tvTotalBudget.setText("Rp "+ sharedPreferences.getString("totalbudget",""));

        String id_wisata = sharedPreferences.getString("id_wisata","");
        String id_kamar = sharedPreferences.getString("id_kamar","");
        String id_menu = sharedPreferences.getString("id_menu","");

        Log.d("TravelFragment","true");
        Log.d("selectedWisata",id_wisata);
        Log.d("selectedKamar",id_kamar);
        Log.d("selectedMenu",id_menu);
        Log.d("total budget", sharedPreferences.getString("totalbudget",""));
        Log.d("sisa budget", sharedPreferences.getString("sisabudget",""));

        ApiServices.service_post.package_recomendation_wisata(id_wisata, "wisata").enqueue(new Callback<ArrayList<Wisata>>() {
            @Override
            public void onResponse(Call<ArrayList<Wisata>> call, Response<ArrayList<Wisata>> response) {
                travels = response.body();

                rcTravel.setAdapter(new MyTravelWisataAdapter(getContext(), travels));
                rcTravel.getAdapter().notifyDataSetChanged();

                Log.d("success",response.body().toString());
            }

            @Override
            public void onFailure(Call<ArrayList<Wisata>> call, Throwable t) {
                Log.d("error",t.getMessage());

            }
        });

        ApiServices.service_post.package_recomendation_kamar(id_kamar, "kamar").enqueue(new Callback<ArrayList<Kamar>>() {
            @Override
            public void onResponse(Call<ArrayList<Kamar>> call, Response<ArrayList<Kamar>> response) {
                hotels = response.body();

                rcHotel.setAdapter(new MyTravelKamarAdapter(getContext(), hotels));
                rcHotel.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<Kamar>> call, Throwable t) {

            }
        });

        ApiServices.service_post.package_recomendation_menu(id_menu, "menu").enqueue(new Callback<ArrayList<Menu>>() {
            @Override
            public void onResponse(Call<ArrayList<Menu>> call, Response<ArrayList<Menu>> response) {
                menus = response.body();

                rcRestaurant.setAdapter(new MyTravelMenuAdapter(getContext(), menus));
                rcRestaurant.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<Menu>> call, Throwable t) {

            }
        });

        return view;
    }

}
