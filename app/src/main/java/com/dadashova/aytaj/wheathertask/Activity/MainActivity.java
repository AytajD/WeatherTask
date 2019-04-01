package com.dadashova.aytaj.wheathertask.Activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.dadashova.aytaj.wheathertask.HttpClient.RetrofitInstance;
import com.dadashova.aytaj.wheathertask.HttpClient.WheatherService;
import com.dadashova.aytaj.wheathertask.R;

import java.util.ArrayList;
import java.util.List;

import com.dadashova.aytaj.wheathertask.Models.Data;
import com.dadashova.aytaj.wheathertask.Models.ResponseModel;
import com.dadashova.aytaj.wheathertask.RecyclerView.RecyclerAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private List<Data> mDataList;
    private RecyclerAdapter mAdapter;

    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        mDataList = new ArrayList<>();

        getWheatherData();
    }

    private void getWheatherData() {

        WheatherService wheatherService = RetrofitInstance.getRetrofitInstance().create(WheatherService.class);

        Call<ResponseModel> call = wheatherService.getDailyWheather("abc");

        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                progressDialog.dismiss();
                getDataList(response.body());
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void getDataList(ResponseModel body) {

        ResponseModel apiResponse = body;
        if ((apiResponse).getmDaily() != null) {
            for (int i = 0; i < apiResponse.getmDaily().getmData().size(); i++) {
                mDataList.add(apiResponse.getmDaily().getmData().get(i));
            }

            LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

            mAdapter = new RecyclerAdapter(MainActivity.this, mDataList);
            mRecyclerView.setLayoutManager(layoutManager);
            mRecyclerView.setAdapter(mAdapter);






    }


        }
    }
