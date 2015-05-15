package com.zoomcreativo.turbo_menufragments;

import android.app.Activity;
import android.app.DialogFragment;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Acercade  extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(Locale.getDefault().getLanguage().equals("sp"))
        {
        getDialog().setTitle("Acerca de...");
        }
        else
        {
        getDialog().setTitle("About ...");
        }
        return inflater.inflate(R.layout.fragment_acercade,null);
    }
}
