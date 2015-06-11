package com.zoomcreativo.turbo_menufragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.database.Cursor;
import android.os.Bundle;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class Mapas extends Fragment {

    private Cursor cursor;
    String[] datosna;
    String[] datosla;
    String[] datoslo;
    private GoogleMap map;
    private CameraUpdate cameraUpdate;
    private final LatLng LOCATION_TURBO = new LatLng(8.094658f, -76.728474f);
    private View RootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        try{
            RootView = inflater.inflate(R.layout.fragment_mapas, container, false);

            map = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
            map.addMarker(new MarkerOptions().position(LOCATION_TURBO).title("Turbo - Antioquia").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

            Button ubiboton = (Button) RootView.findViewById(R.id.ubica);
            ubiboton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    cameraUpdate = CameraUpdateFactory.newLatLngZoom(LOCATION_TURBO, 13);
                    map.animateCamera(cameraUpdate);
                }
            });


        }
        catch (InflateException e){

        }
        return RootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        try{
            Fragment fragment = (getFragmentManager().findFragmentById(R.id.map));
            FragmentTransaction ft = getActivity().getFragmentManager().beginTransaction();
            ft.remove(fragment);
            ft.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        try{
            Fragment fragment = (getFragmentManager().findFragmentById(R.id.map));
            FragmentTransaction ft = getActivity().getFragmentManager().beginTransaction();
            ft.remove(fragment);
            ft.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
