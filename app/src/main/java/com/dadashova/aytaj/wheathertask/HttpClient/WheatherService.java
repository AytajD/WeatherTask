package com.dadashova.aytaj.wheathertask.HttpClient;

import com.dadashova.aytaj.wheathertask.Models.ResponseModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface WheatherService {

    @Headers({"Static-Header1: 123", "Static-Header2: 456"})
    @GET("40.409264,49.867092")
    Call<ResponseModel> getDailyWheather(@Header("Dynamic-header") String header);

    //I have commented out this request and use the abowe one.
    // Because the all data were cloudy in below one :D
    //but I have already learned about Queries and Path:)

   /* @GET("{coordination}/")
    Call<ApiResponseModel> getResult(
            @Path("coordination") String cord,
            @Query("lang") String lang);*/


}
