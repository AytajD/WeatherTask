package com.dadashova.aytaj.wheathertask.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Daily {
    @SerializedName("data")
    private List<Data> mData;

    public List<Data> getmData() {
        return mData;
    }
}
