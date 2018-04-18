package com.pens.travelme.travelme.frag_lets.recommend.recommend_restaurant;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pens.travelme.travelme.R;
import com.pens.travelme.travelme.api.ApiServices;
import com.pens.travelme.travelme.frag_lets.recommend.RecommendActivity;
import com.pens.travelme.travelme.modal.Menu;
import com.pens.travelme.travelme.modal.MyChoice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReRestaurantFragment extends Fragment {
    public static final String RERESTO_FRAG_TAG = "ReHotelFragment";

    private RecyclerView rcRestaurant;
    private List<Menu> menus = new ArrayList<>();

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
        rcRestaurant.setFocusable(false);

        loadMenuData();

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RecommendActivity.currentFragment = RecommendActivity.HOTEL;
    }

    public void loadMenuData() {
        final MyChoice myChoice = ((RecommendActivity) getActivity()).getMyChoice();

        ApiServices.service_post.get_r_menu(
                "menu",
                myChoice.getJumPorsi(),
                myChoice.getBudget()
        ).enqueue(new Callback<ArrayList<Menu>>() {
            @Override
            public void onResponse(Call<ArrayList<Menu>> call, Response<ArrayList<Menu>> response) {
                menus = response.body();

                rcRestaurant.setAdapter(new ReRestaurantAdapter(getContext(), menus, myChoice.getJumPorsi()));
                rcRestaurant.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<Menu>> call, Throwable t) {
                Log.d(RERESTO_FRAG_TAG, t.getMessage());
            }
        });
    }

}
