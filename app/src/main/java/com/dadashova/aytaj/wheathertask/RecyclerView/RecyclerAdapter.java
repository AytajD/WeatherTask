package com.dadashova.aytaj.wheathertask.RecyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dadashova.aytaj.wheathertask.R;

import java.util.List;

import com.dadashova.aytaj.wheathertask.Models.Data;

public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder>{

    public static final String MAX_TEMPRATUR = "Maksimum tempratur: ";
    public static final String MIN_TEMPRATUR = "Minimum tempratur: ";
    public static final String HUMIDITY = "Rutubet: ";
    public static final String WIND_SPEED= "Kuleyin Sureti: ";

    private List<com.dadashova.aytaj.wheathertask.Models.Data> mDataList;
    private Context context;



    public RecyclerAdapter( Context context, List<com.dadashova.aytaj.wheathertask.Models.Data> dataList) {
        this.mDataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {


        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view =  layoutInflater.inflate( R.layout.item_row_sunny,viewGroup, false);

        return new ViewHolder(view);



    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Data data = mDataList.get(i);

        viewHolder.mSummary.setText(mDataList.get(i).getSummary());
        viewHolder.mMaxTemp.setText(MAX_TEMPRATUR + (mDataList.get(i).getmTempratureHight()));
        viewHolder.mMinTemp.setText(MIN_TEMPRATUR + (mDataList.get(i).getmTempratureLow()));
        viewHolder.mHumidity.setText(HUMIDITY+ mDataList.get(i).getHumidity());
        viewHolder.mSpeed.setText(WIND_SPEED + mDataList.get(i).getWindSpeed());

        String mIcon = mDataList.get(i).getmIcon();

        setIcon(mIcon, viewHolder);


    }

    private void setIcon(String mIcon, ViewHolder viewHolder) {

        switch (mIcon){

        case "cloudy":
            viewHolder.mImageWheather.setImageResource(R.drawable.ic_partly_cloud);
            break;
        case "partly-cloudy-day":
            viewHolder.mImageWheather.setImageResource(R.drawable.ic_cloudly);
            break;
        case "clear":
            viewHolder.mImageWheather.setImageResource(R.drawable.ic_sunny);
            break;
        case "rain":
            viewHolder.mImageWheather.setImageResource(R.drawable.ic_rainy);
            break;


    }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }



















}
