package com.osafak.currencyexchange;


import android.app.ProgressDialog;
import android.support.v4.app.Fragment;

/**
 * Created by Onur on 1.11.2016.
 */

public class CurrencyListActivity extends SingleFragmentActivity {

    protected Fragment createFragment(){

        return new CurrencyListFragment();}
}
