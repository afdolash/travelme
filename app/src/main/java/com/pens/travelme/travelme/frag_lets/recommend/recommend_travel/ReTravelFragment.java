package com.pens.travelme.travelme.frag_lets.recommend.recommend_travel;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pens.travelme.travelme.R;
<<<<<<< HEAD:app/src/main/java/com/pens/travelme/travelme/frag_lets/recommend/recommend_travel/ReTravelFragment.java
import com.pens.travelme.travelme.modal.Travel;
=======
>>>>>>> uki:app/src/main/java/com/pens/travelme/travelme/lets_travel/recommend/recommend_travel/ReTravelFragment.java

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReTravelFragment extends Fragment {

    private RecyclerView rcTravel;
    private List<Travel> travels = new ArrayList<>();

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
        rcTravel.setAdapter(new ReTravelAdapter(getContext(), travels));
        rcTravel.setFocusable(false);

        loadTravelData();

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

}
