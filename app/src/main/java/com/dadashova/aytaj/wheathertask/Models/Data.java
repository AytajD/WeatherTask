package com.dadashova.aytaj.wheathertask.Models;

import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("temperatureHigh")
    private Double mTempratureHight;
    @SerializedName("temperatureLow")
    private Double mTempratureLow;
    @SerializedName("summary")
    private String mSummary;
    @SerializedName("humidity")
    private String mHumidity;
    @SerializedName("windSpeed")
    private String mWindSpeed;
    @SerializedName("icon")
    private String mIcon;



    public String getSummary() {
        return mSummary;
    }

    public String getmIcon() {
        return mIcon;
    }

    public String getHumidity() {
        return mHumidity;
    }

    public String getWindSpeed() {
        return mWindSpeed;
    }

    public Double getmTempratureHight() {
        return mTempratureHight;
    }

    public Double getmTempratureLow() {
        return mTempratureLow;
    }
}
