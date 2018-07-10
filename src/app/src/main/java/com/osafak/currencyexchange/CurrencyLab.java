package com.osafak.currencyexchange;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.ListView;
import android.widget.Toast;
import com.osafak.currencyexchange.CurrencyService;
import com.osafak.currencyexchange.RetrofitModel;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import retrofit.RestAdapter;
import retrofit.RetrofitError;



/**
 * Created by Onur on 31.10.2016.
 */

public class CurrencyLab {
    private static CurrencyLab sCurrencyLab;
    private ArrayList<Currency> mCurrency;
    private ListView listView;
    private RestAdapter restAdapter;
    private CurrencyService mCurrencyService;


    public static CurrencyLab get(Context context)
    {

        if(sCurrencyLab==null)
        {
            sCurrencyLab=new CurrencyLab(context);
        }
        return sCurrencyLab;
    }

    private CurrencyLab(final Context context)
    {

        mCurrency=new ArrayList<>();
        restAdapter=new RestAdapter.Builder().setEndpoint("https://www.doviz.com").build();
        mCurrencyService=restAdapter.create(CurrencyService.class);
        mCurrencyService.getJsonValues(new retrofit.Callback<RetrofitModel[]>() {
            @Override
            public void success(RetrofitModel[] retrofitModels, retrofit.client.Response response) {
                for(RetrofitModel retrofitModel: retrofitModels){

                    Currency currency = new Currency();
                    currency.setmCurrenyFullName(retrofitModel.getFullName());
                    currency.setmSellPrice(retrofitModel.getSelling());
                    currency.setmBuyPrice(retrofitModel.getBuying());
                    currency.setmChangeRate(retrofitModel.getChangeRate());
                    mCurrency.add(currency);
                }

            }


            @Override
            public void failure(RetrofitError error) {

            }
        });

    }
    public List<Currency> getCurrencies()
    {
        return mCurrency;
    }

}
