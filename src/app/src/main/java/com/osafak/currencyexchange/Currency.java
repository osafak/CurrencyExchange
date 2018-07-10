package com.osafak.currencyexchange;

import java.text.DecimalFormat;
import java.util.UUID;

/**
 * Created by Onur on 31.10.2016.
 */

public class Currency {
    private String mCurrenyFullName;
    private String mCurrencyName;
    private double mSellPrice;
    private String mUpdateDate;
    private int mCurrency;
    private double mBuyPrice;
    private String mCode;
    private double mChangeRate;

    public UUID getmID() {
        return mID;
    }

    public void setmID(UUID mID) {
        this.mID = mID;
    }

    private UUID mID;

    public double getmChangeRate() {
        return mChangeRate;
    }

    public void setmChangeRate(double mChangeRate) {
        this.mChangeRate = mChangeRate;
    }

    public String getmCode() {
        return mCode;
    }

    public void setmCode(String mCode) {
        this.mCode = mCode;
    }

    public String getmBuyPrice() {
        String x=new DecimalFormat("#,###0.000").format(mBuyPrice);
        return x;
    }

    public void setmBuyPrice(double mBuyPrice) {
        this.mBuyPrice = mBuyPrice;
    }

    public int getmCurrency() {
        return mCurrency;
    }

    public void setmCurrency(int mCurrency) {
        this.mCurrency = mCurrency;
    }

    public String getmUpdateDate() {
        return mUpdateDate;
    }

    public void setmUpdateDate(String mUpdateDate) {
        this.mUpdateDate = mUpdateDate;
    }

    public String getmSellPrice() {
        String x=new DecimalFormat("#,###0.000").format(mSellPrice);
        return x;
    }

    public void setmSellPrice(double mSellPrice) {
        this.mSellPrice = mSellPrice;
    }

    public String getmCurrencyName() {
        return mCurrencyName;
    }

    public void setmCurrencyName(String mCurrencyName) {
        this.mCurrencyName = mCurrencyName;
    }

    public String getmCurrenyFullName() {
        return mCurrenyFullName;
    }

    public void setmCurrenyFullName(String mCurrenyFullName) {
        this.mCurrenyFullName = mCurrenyFullName;
    }
}
