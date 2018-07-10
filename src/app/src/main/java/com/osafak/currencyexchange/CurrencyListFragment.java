package com.osafak.currencyexchange;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import junit.framework.Test;

import java.util.List;

/**
 * Created by Onur on 31.10.2016.
 */

public class CurrencyListFragment extends Fragment {
    private RecyclerView mCurrencyRecyclerView;
    private CurrencyAdapter mAdapter;
    private ProgressDialog mPD;
    InterstitialAd mIntersititialAd;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_currency_list, container, false);

        mCurrencyRecyclerView = (RecyclerView) view
                .findViewById(R.id.currency_recycler_view);
        mCurrencyRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mIntersititialAd=new InterstitialAd(getContext());
        mIntersititialAd.setAdUnitId("ca-app-pub-5728089941058738/1935750007");
        mIntersititialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }
            @Override
            public void onAdLoaded() {
                super.onAdClosed();
                mIntersititialAd.show();
            }
        });
        updateUI(getContext());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return view;
    }

    private void LoadIntersAd() {
        AdRequest adRequestInters=new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mIntersititialAd.loadAd(adRequestInters);
    }
    public boolean InternetControl() {
        ConnectivityManager manager =(ConnectivityManager)getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager.getActiveNetworkInfo() != null
                && manager.getActiveNetworkInfo().isAvailable()
                && manager.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            return false;
        }
    }

    private void updateUI(Context context) {
        if (InternetControl())
        {
            CurrencyLab currencyLab=CurrencyLab.get(getActivity());
            List<Currency> currencies=currencyLab.getCurrencies();
            mAdapter=new CurrencyAdapter(currencies);
            mCurrencyRecyclerView.setAdapter(mAdapter);
        }
        else
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("İnternet Bağlantısı Yok");
            builder.setMessage("Uygulama Kapatılacaktır. Lütfen internet bağlantınızı açtıktan sonra uygulamayı yeniden çalıştırınız.");
            builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    getActivity().finish();

                }
            });


            builder.show();
        }

    }
    private class CurrencyHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private TextView mNameTextView;
        private TextView mBuyTextView;
        private TextView mSellTextView;
        private Currency mCurrency;
        private ImageView mImageView;
        public CurrencyHolder(View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(this);
            mNameTextView=(TextView)itemView.findViewById(R.id.CurrencyName);
            mBuyTextView=(TextView)itemView.findViewById(R.id.Buying);
            mSellTextView=(TextView)itemView.findViewById(R.id.Selling);
            mImageView=(ImageView)itemView.findViewById(R.id.statusImage);
        }
        public void bindCurrency(Currency currency)
        {
            mCurrency=currency;
            if (mCurrency.getmChangeRate()<0)
            {
                mImageView.setBackgroundResource(R.drawable.down);
            }
            else if (mCurrency.getmChangeRate()>0)
            {
                mImageView.setBackgroundResource(R.drawable.up);
            }
            String f=mCurrency.getmSellPrice().replace(",",".");
            String g=mCurrency.getmBuyPrice().replace(",",".");
            if (Float.valueOf(f)!=0&&Float.valueOf(f)!=0) {
                mSellTextView.setText(String.valueOf(mCurrency.getmSellPrice()));
                mNameTextView.setText(String.valueOf(mCurrency.getmCurrenyFullName()));
                mBuyTextView.setText(String.valueOf(mCurrency.getmBuyPrice()));
            }

        }

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getContext(),CalculateCurrency.class);
            intent.putExtra("Currency_name",mCurrency.getmCurrenyFullName().toString());
            intent.putExtra("Currency_rate",mCurrency.getmBuyPrice());
            LoadIntersAd();
            startActivity(intent);
        }
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_currency_list, menu);
    }
    @Override public boolean onOptionsItemSelected(MenuItem item) {
        updateUI(getContext());
            Toast.makeText(getActivity(), "Yenilendi", Toast.LENGTH_SHORT).show();
        return true;
    }

    private class CurrencyAdapter extends RecyclerView.Adapter<CurrencyHolder>
    {
        private List<Currency> mCurrencies;
        public CurrencyAdapter(List<Currency> currencies){mCurrencies=currencies;}
        @Override
        public CurrencyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater=LayoutInflater.from(getActivity());
            View view=layoutInflater.inflate(R.layout.list_item_currency,parent,false);
            return new CurrencyHolder(view);

        }

        @Override
        public void onBindViewHolder(CurrencyHolder holder, int position) {
            Currency currency=mCurrencies.get(position);
            holder.bindCurrency(currency);

        }

        @Override
        public int getItemCount() {
            return mCurrencies.size();
        }
    }


}

