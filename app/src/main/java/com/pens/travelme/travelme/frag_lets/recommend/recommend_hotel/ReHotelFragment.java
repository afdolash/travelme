package com.pens.travelme.travelme.frag_lets.recommend.recommend_hotel;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pens.travelme.travelme.R;
import com.pens.travelme.travelme.api.ApiServices;
import com.pens.travelme.travelme.frag_lets.recommend.RecommendActivity;
import com.pens.travelme.travelme.modal.Kamar;
import com.pens.travelme.travelme.modal.MyChoice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReHotelFragment extends Fragment {
    public static final String REHOTEL_FRAG_TAG = "ReHotelFragment";

    private RecyclerView rcHotel;
    private List<Kamar> hotels = new ArrayList<>();

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
        rcHotel.setFocusable(false);

        loadHotelData();

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RecommendActivity.currentFragment = RecommendActivity.TRAVEL;
    }

    public void loadHotelData() {
        final MyChoice myChoice = ((RecommendActivity) getActivity()).getMyChoice();

        ApiServices.service_post.get_r_kamar(
                "kamar",
                myChoice.getJumKamar(),
                myChoice.getJumDay(),
                myChoice.getBudget()
        ).enqueue(new Callback<ArrayList<Kamar>>() {
            @Override
            public void onResponse(Call<ArrayList<Kamar>> call, Response<ArrayList<Kamar>> response) {
                hotels = response.body();

                rcHotel.setAdapter(new ReHotelAdapter(getContext(), hotels, myChoice.getJumKamar()));
                rcHotel.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<Kamar>> call, Throwable t) {
                Log.d(REHOTEL_FRAG_TAG, t.getMessage());
            }
        });
    }
}
