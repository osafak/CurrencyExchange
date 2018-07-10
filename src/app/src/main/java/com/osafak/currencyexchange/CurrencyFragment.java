package com.osafak.currencyexchange;

import com.osafak.currencyexchange.RetrofitModel;
import android.os.Bundle;
import android.view.View;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;


/**
 * Created by Onur on 1.11.2016.
 */

public class CurrencyFragment extends Fragment {
    private Currency mCurrency;
    private TextView mNameTextView;
    private TextView mBuyTextView;
    private TextView mSellTextView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCurrency=new Currency();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.activity_currency,container,false);



       return v;
    }

    public static Fragment newInstance(UUID uuıd) {
        return null;
    }
}
