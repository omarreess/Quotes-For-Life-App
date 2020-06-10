package com.omaressam.quotesforlife;

import android.os.Bundle;
import android.os.Handler;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.omaressam.quotesforlife.UI.Home.HomeFragment;
import com.omaressam.quotesforlife.UI.Splash.SplashScreenFragment;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Bind Framgent
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        SplashScreenFragment SplashFragment =new SplashScreenFragment();
        fragmentTransaction.add(R.id.frame_layout,SplashFragment );
        fragmentTransaction.commit();

        //after this time it will replaced with new fragment

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                HomeFragment HomeFragment = new HomeFragment();
                FragmentTransaction newTransaction = getSupportFragmentManager().beginTransaction();
                newTransaction.replace(R.id.frame_layout, HomeFragment);
                newTransaction.commit();
            }
        },3400  );


    }


}
