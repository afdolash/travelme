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

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("myTravel", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        RecyclerView.LayoutManager travelLayout = new LinearLayoutManager(getContext());
        rcTravel.setLayoutManager(travelLayout);
        rcTravel.setItemAnimator(new DefaultItemAnimator());
        rcTravel.setFocusable(false);

        Log.d("TravelFragment","true");
        Log.d("selectedWisata",sharedPreferences.getString("id_wisata",""));
        Log.d("selectedKamar",sharedPreferences.getString("id_kamar",""));
        Log.d("selectedMenu",sharedPreferences.getString("id_menu",""));
        return view;
    }

}
