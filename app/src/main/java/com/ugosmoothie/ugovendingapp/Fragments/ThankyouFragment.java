package com.ugosmoothie.ugovendingapp.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ugosmoothie.ugovendingapp.R;

/**
 * Created by SachinApiah on 6/22/2016.
 */
public class ThankyouFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootView = inflater.inflate(R.layout.thank_you, container, false);

        return rootView;
    }

}
