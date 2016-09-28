package com.ugosmoothie.ugovendingapp.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.ugosmoothie.ugovendingapp.Data.*;
import com.ugosmoothie.ugovendingapp.PurchaseSmoothie;
import com.ugosmoothie.ugovendingapp.R;

/**
 * Created by Michelle on 3/14/2016
 */

public class SmoothieSelectionFragment extends Fragment {

    private int green_machine = 0;
    private int tropical_paradise = 1;
    private int berry_licious = 2;

    public int getGreen_machine(){
        return green_machine;
    }

    public int getTropical_paradise() {
        return tropical_paradise;
    }

    public int getBerry_licious() {
        return berry_licious;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {

        inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rootView = inflater.inflate(R.layout.smoothie_selection_view, container, false);
        final Button lang =  (Button) rootView.findViewById(R.id.lingual_tag);
        final Button info = (Button) rootView.findViewById((R.id.info_tag));
        final Button dismiss_info = (Button) rootView.findViewById((R.id.exit_tag));
        final View container_pop = (View) rootView.findViewById(R.id.smoothieInfo);
        RelativeLayout smoothie_g = (RelativeLayout) rootView.findViewById(R.id.smoothie_g);
        RelativeLayout smoothie_t = (RelativeLayout) rootView.findViewById(R.id.smoothie_t);
        RelativeLayout smoothie_b = (RelativeLayout) rootView.findViewById(R.id.smoothie_b);

        //Initiates ingredients pop-up
        info.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                container_pop.setVisibility(View.VISIBLE);
            }
        });

        //Closes ingredients pop-up
        dismiss_info.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                container_pop.setVisibility(View.INVISIBLE);
            }
        });

        //Language Change
        lang.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((PurchaseSmoothie) getActivity()).ToggleLanguage();
            }
        });

        //Smoothie Selection: Save on data on remote cache and move to next fragment
        smoothie_g.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentSelection.getInstance().setCurrentSmoothie(getGreen_machine());
                CurrentSelection.getInstance().setCurrentLiquid(0);
                CurrentSelection.getInstance().setCurrentSupplement(0);
                ((PurchaseSmoothie) getActivity()).GetUGoViewPager().setCurrentItem(3);
            }
        });
        smoothie_t.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentSelection.getInstance().setCurrentSmoothie(getTropical_paradise());
                CurrentSelection.getInstance().setCurrentLiquid(0);
                CurrentSelection.getInstance().setCurrentSupplement(0);
                ((PurchaseSmoothie) getActivity()).GetUGoViewPager().setCurrentItem(3);
            }
        });
        smoothie_b.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentSelection.getInstance().setCurrentSmoothie(getBerry_licious());
                CurrentSelection.getInstance().setCurrentLiquid(0);
                CurrentSelection.getInstance().setCurrentSupplement(0);
                ((PurchaseSmoothie) getActivity()).GetUGoViewPager().setCurrentItem(3);
            }
        });

        return rootView;
    }
}

