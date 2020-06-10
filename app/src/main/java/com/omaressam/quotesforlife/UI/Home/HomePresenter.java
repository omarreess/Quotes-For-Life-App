package com.omaressam.quotesforlife.UI.Home;

import com.omaressam.quotesforlife.Data.NetworkLayer.Api;
import com.omaressam.quotesforlife.Data.NetworkLayer.QuoteBody;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomePresenter implements HomeContract {
    private HomeView homeView;
    public HomePresenter(HomeView homeView) {
        this.homeView =homeView;
    }

    @Override
    public void fetchData() {
        try {
            //Call
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Api.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            //implemnet interface
            Api api = retrofit.create(Api.class);
            // reqeust
            Call<QuoteBody> call = api.getQuote("en");

            call.enqueue(new Callback<QuoteBody>() {
                @Override
                public void onResponse(Call<QuoteBody> call, Response<QuoteBody> response) {
                    if (response.body() != null) {
                            //Filling View with Response Data
                           homeView.settingData(response.body().getContent(),"- " + response.body().getOriginatorQuoteBody().getName());




                    }

                }

                @Override
                public void onFailure(Call<QuoteBody> call, Throwable t) {
                    // Show Error
                    homeView.showErrorMsg(t.getMessage());

                }
            });

        } catch (Exception e) {
            // Show Error
            homeView.showErrorMsg(e.getMessage());
         }

    }
}
