package com.pens.travelme.travelme.frag_travel;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.AccountPicker;
import com.pens.travelme.travelme.R;
import com.pens.travelme.travelme.api.ApiServices;
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

    private RecyclerView rcTravel;
    private Packages packages ;

    public TravelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_travel, container, false);

        rcTravel = (RecyclerView) view.findViewById(R.id.rc_travel);

        RecyclerView.LayoutManager travelLayout = new LinearLayoutManager(getContext());
        rcTravel.setLayoutManager(travelLayout);
        rcTravel.setItemAnimator(new DefaultItemAnimator());
        rcTravel.setFocusable(false);

        Log.d("TravelFragment","true");
        ApiServices.service_post.package_recomendation(",5,6,7,8",",7,8,9,10","9,10,11,12").enqueue(new Callback<ArrayList<Packages>>() {
            @Override
            public void onResponse(Call<ArrayList<Packages>> call, Response<ArrayList<Packages>> response) {
                packages = response.body().get(0);
                Log.d("pcg",packages.toString());

            }

            @Override
            public void onFailure(Call<ArrayList<Packages>> call, Throwable t) {
                Log.e("error",t.getMessage());

            }
        });

        return view;
    }

}
