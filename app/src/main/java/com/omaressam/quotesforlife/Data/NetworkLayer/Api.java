package com.omaressam.quotesforlife.Data.NetworkLayer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface Api {

    String BASE_URL = "https://quotes15.p.rapidapi.com/quotes/random/";

    @Headers({
            "x-rapidapi-host: quotes15.p.rapidapi.com",
            "x-rapidapi-key: 9c02043f1bmsh93142affc502ca3p1b04fdjsn9dc9469a24f7",
            "useQueryString: true"
    })
    @GET( "?")
    Call<QuoteBody> getQuote(@Query("language_code") String lang);


}
