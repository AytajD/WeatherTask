package com.dadashova.aytaj.wheathertask.Models;

import com.google.gson.annotations.SerializedName;

public class ResponseModel {

    @SerializedName("daily")
    private Daily mDaily;

    public Daily getmDaily() {
        return mDaily;
    }
}

