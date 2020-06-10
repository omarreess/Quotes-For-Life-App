package com.omaressam.quotesforlife.UI.Home;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.material.button.MaterialButton;
import com.omaressam.quotesforlife.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class HomeFragment extends Fragment implements HomeView {


    @BindView(R.id.new_quote_btn)
    MaterialButton newQuoteBtn;

    @BindView(R.id.quote)
    TextView quote;
    @BindView(R.id.quote_author)
    TextView quoteAuthor;
    @BindView(R.id.progress)
    ProgressBar progress;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        quote.setMovementMethod(new ScrollingMovementMethod());
        changeStatusBarColour();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Initialize App with data
        requestData();
    }

    @OnClick(R.id.new_quote_btn)
    public void onViewClicked() {


       requestData();
       showInterstitialAd();


    }

    //Fetching Data
    HomePresenter homePresenter = new HomePresenter(this);
    @Override
    public void requestData() {
        progress.setVisibility(View.VISIBLE);
        homePresenter.fetchData();
    }

    @Override
    public void settingData(String quote, String author) {
        progress.setVisibility(View.INVISIBLE);
        this.quote.setText(quote);
        quoteAuthor.setText(author);

    }

    @Override
    public void showErrorMsg(String error) {
        progress.setVisibility(View.INVISIBLE);
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }


    //Ad
    private InterstitialAd mInterstitialAd;
    private boolean ShowAdFlag = true;
    @BindView(R.id.home_banner)
    AdView homeBanner;

    @Override
    public void onStart() {
        super.onStart();

        //Ad
        loadInterstitialAd();
        loadAdBanner();



    }



    @Override
    public void loadAdBanner() {
        AdRequest adRequest = new AdRequest.Builder().build();
        homeBanner.loadAd(adRequest);
    }

    @Override
    public void loadInterstitialAd() {
        mInterstitialAd = new InterstitialAd(getContext());
        mInterstitialAd.setAdUnitId(getResources().getString(R.string.new_quote_inist));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

    }

    @Override
    public void showInterstitialAd() {
        if (ShowAdFlag) {
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
            ShowAdFlag = false;
        } else {
            ShowAdFlag = true;
        }
    }
    @Override
    public void changeStatusBarColour() {
        getActivity().getWindow().setStatusBarColor(getResources().getColor(R.color.blue_maintheme));

    }
}