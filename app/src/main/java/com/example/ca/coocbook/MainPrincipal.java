package com.example.ca.coocbook;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static android.R.attr.fragment;

/**
 * Created by Judith on 29/10/2016.
 */

public class MainPrincipal extends android.support.v4.app.Fragment {
    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.activity_main, container, false);
        return myView;
    }
}
