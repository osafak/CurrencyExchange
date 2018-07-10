package com.osafak.currencyexchange;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class CalculateCurrency extends AppCompatActivity {

    private TextView mCurrencyDetailName;
    private TextView mCurrencyDetailRate;
    private Button mCurrencyDetailCalculate;
    private TextView mCalculateResult;
    private EditText mCalculateRate;
    private ScrollView mScrollView;
    String mRate;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_currency);
        Bundle extras=getIntent().getExtras();
        String mCurrencyName=extras.getString("Currency_name");
        mRate=extras.getString("Currency_rate");


        mCurrencyDetailName=(TextView)findViewById(R.id.CurrencyDetailName);
        mCalculateResult=(TextView)findViewById(R.id.CurrencyCalculateResult);
        mCurrencyDetailRate=(TextView)findViewById(R.id.CurrencyDetailSell);
        mCurrencyDetailCalculate=(Button)findViewById(R.id.CurrencyDetailCalculate);
        mCalculateRate=(EditText)findViewById(R.id.CurrencyDetail);
        mCurrencyDetailName.setText(mCurrencyName);
        mScrollView=(ScrollView)findViewById(R.id.scView);
        mCurrencyDetailRate.setText(String.valueOf(mRate));
        mCalculateRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mScrollView.fullScroll(v.FOCUS_DOWN);

            }
        });

        mCurrencyDetailCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(mCalculateRate.getText().toString().trim().length()!=0)
                {
                    String s = mRate.replace(",",".");

                    float deger=Float.parseFloat(s)*(Float.parseFloat(mCalculateRate.getText().toString()));
                    mCalculateResult.setText(String.valueOf(deger)+" TL");
                }
                else
                {
                    mCalculateResult.setText("Herhangi bir değer girmediniz.");
                }


            }
        });

LoadAds();


    }

    private void LoadAds() {
        adView=new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(getString(R.string.adsUnit));
        LinearLayout layout=(LinearLayout)findViewById(R.id.adsFill);
        layout.addView(adView);

        AdRequest mAdRequest=new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        adView.loadAd(mAdRequest);
    }

}
