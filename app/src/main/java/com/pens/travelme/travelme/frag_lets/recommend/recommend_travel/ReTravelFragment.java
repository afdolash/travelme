package com.pens.travelme.travelme.frag_lets.recommend.recommend_travel;


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
import com.pens.travelme.travelme.modal.MyChoice;
import com.pens.travelme.travelme.modal.Wisata;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReTravelFragment extends Fragment {
    public static final String RETRAVEL_FRAG_TAG = "ReTravelFragment";

    private RecyclerView rcTravel;
    private List<Wisata> travels = new ArrayList<>();

    public ReTravelFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_re_travel, container, false);

        rcTravel = (RecyclerView) view.findViewById(R.id.rc_travel);

        RecyclerView.LayoutManager travelLayout = new LinearLayoutManager(getContext());
        rcTravel.setLayoutManager(travelLayout);
        rcTravel.setItemAnimator(new DefaultItemAnimator());
        rcTravel.setFocusable(false);

        loadWisataData();

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().finish();
    }

    public void loadWisataData() {
        final MyChoice myChoice = ((RecommendActivity) getActivity()).getMyChoice();
        Toast.makeText(getContext(), myChoice.getBudget().toString(), Toast.LENGTH_SHORT).show();

        ApiServices.service_post.get_r_wisata(
                "wisata",
                myChoice.getCategoryWisata().toString(),
                myChoice.getTicketChild(),
                myChoice.getTicketAdult(),
                myChoice.getBudget()
        ).enqueue(new Callback<ArrayList<Wisata>>() {
            @Override
            public void onResponse(Call<ArrayList<Wisata>> call, Response<ArrayList<Wisata>> response) {
                travels = response.body();

                rcTravel.setAdapter(new ReTravelAdapter(getContext(), travels, myChoice.getTicketMotor(), myChoice.getTicketCar(), myChoice.getTicketBus(), myChoice.getTicketAdult(), myChoice.getTicketChild()));
                rcTravel.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<Wisata>> call, Throwable t) {
                Log.d(RETRAVEL_FRAG_TAG, t.getMessage());
            }
        });
    }

}
