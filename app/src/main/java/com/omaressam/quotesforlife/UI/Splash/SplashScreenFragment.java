package com.omaressam.quotesforlife.UI.Splash;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.omaressam.quotesforlife.R;


public class SplashScreenFragment extends Fragment implements SplashScreenView {








    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_splash_screen, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
     changeStatusBarColour();
    }

    @Override
    public void changeStatusBarColour() {
        getActivity().getWindow().setStatusBarColor(getResources().getColor(R.color.white));

    }
}
