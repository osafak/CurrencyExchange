package com.osafak.currencyexchange;


import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class RetrofitModel {

    @SerializedName("selling")
    @Expose
    public Float selling;
    @SerializedName("update_date")
    @Expose
    public Integer updateDate;
    @SerializedName("currency")
    @Expose
    public Integer currency;
    @SerializedName("buying")
    @Expose
    public Float buying;
    @SerializedName("change_rate")
    @Expose
    public Float changeRate;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("full_name")
    @Expose
    public String fullName;
    @SerializedName("code")
    @Expose
    public String code;

    public Float getSelling() {
        return selling;
    }
    public Integer getUpdateDate() {
        return updateDate;
    }
    Integer getCurrency() {
        return currency;
    }
    public Float getBuying() {
        return buying;
    }
    public Float getChangeRate() {
        return changeRate;
    }
    public String getName() {
        return name;
    }
    public String getFullName() {
        return fullName;
    }
    public String getCode() {
        return code;
    }
}