package com.pens.travelme.travelme.actv_detail.sub_frag_penginapan;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pens.travelme.travelme.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class KamarFragment extends Fragment {


    public KamarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kamar, container, false);
    }

}