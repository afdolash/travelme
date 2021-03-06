package com.pens.travelme.travelme.actv_detail.sub_frag_penginapan;


import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.pens.travelme.travelme.R;
import com.pens.travelme.travelme.actv_detail.DetailPenginapanActivity;
import com.pens.travelme.travelme.modal.Penginapan;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class PenginapanFragment extends Fragment {

    private TextView tvTitle, tvAddress, tvDescription, tvPhone, tvFacilities;
    private GoogleMap map;
    private SupportMapFragment mapFragment;
    private Penginapan penginapan;

    public PenginapanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_penginapan, container, false);

        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        tvAddress = (TextView) view.findViewById(R.id.tv_address);
        tvDescription = (TextView) view.findViewById(R.id.tv_description);
        tvFacilities = (TextView) view.findViewById(R.id.tv_facilities);
        tvPhone = (TextView) view.findViewById(R.id.tv_phone);

        penginapan = ((DetailPenginapanActivity) getActivity()).getPenginapan();

        Geocoder geocoder = new Geocoder(getContext(), Locale.ENGLISH);
        try {
            List<Address> addresses = geocoder.getFromLocation(penginapan.getPosisi_lat(), penginapan.getPosisi_lng(), 1);

            if (addresses.size() > 0) {
                Address fetchedAddress = addresses.get(0);
                tvAddress.setText(fetchedAddress.getAddressLine(0));
            } else {
                tvAddress.setText("-");
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("DetailPenginapanActiv", e.getMessage());
            tvAddress.setText("-");
        }

        tvTitle.setText(penginapan.getNama());
        tvDescription.setText(penginapan.getDeskripsi());
        tvFacilities.setText(penginapan.getFasilitas());
        tvPhone.setText(penginapan.getNo_telp());

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;

                LatLng latLng = new LatLng(penginapan.getPosisi_lat(),  penginapan.getPosisi_lng());
                map.addMarker(new MarkerOptions().position(latLng).title(penginapan.getNama()));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12.0f));
                map.getUiSettings().setAllGesturesEnabled(true);
            }
        });

        return view;
    }

}
