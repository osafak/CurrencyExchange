package com.osafak.currencyexchange;

import com.osafak.currencyexchange.Retrofit;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Onur on 1.11.2016.
 */

public interface CurrencyService {
    @GET("/api/v1/currencies/all/latest")
    void getJsonValues(Callback<RetrofitModel[]> response);
}
