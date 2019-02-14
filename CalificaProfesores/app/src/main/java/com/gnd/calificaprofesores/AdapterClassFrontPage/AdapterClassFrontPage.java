package com.gnd.calificaprofesores.AdapterClassFrontPage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.gnd.calificaprofesores.R;

public class AdapterClassFrontPage extends FragmentPagerAdapter  {

    private final String[] TITLES = {
            "VISTA GENERAL",
            "OPINIONES RECIENTES",
            "TU OPINIÓN"}; // Opiniones importantes para futuro



    public AdapterClassFrontPage(FragmentManager fm) {
        super(fm);
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }
    public int getCount() {
        return TITLES.length;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ActivityClassFrontPageCapital();
            case 1:
                return new ActivityOpinionRecent();
            case 2:
                return new ActivityYourOpinion();
        }
        return new ActivityYourOpinion();
    }
}

