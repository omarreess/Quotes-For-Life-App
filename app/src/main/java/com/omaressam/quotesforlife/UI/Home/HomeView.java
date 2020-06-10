package com.omaressam.quotesforlife.UI.Home;

public interface HomeView {


    void changeStatusBarColour();

    // Interstitial and banner ad

    void loadAdBanner();
    void loadInterstitialAd();
    void showInterstitialAd();

    // Fetching Data
    void requestData();
    void settingData(String quote , String author );
    void showErrorMsg(String error);
}
