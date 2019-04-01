package com.dadashova.aytaj.wheathertask.RecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dadashova.aytaj.wheathertask.R;

import butterknife.BindView;
import butterknife.ButterKnife;

    public class ViewHolder extends RecyclerView.ViewHolder {
    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);

    }

    @BindView(R.id.image_weather)
    ImageView mImageWheather;
    @BindView(R.id.text_summary)
    TextView mSummary;
    @BindView(R.id.text_max_temp)
    TextView mMaxTemp;
    @BindView(R.id.text_min_temp)
    TextView mMinTemp;
    @BindView(R.id.text_humidity)
    TextView mHumidity;
    @BindView(R.id.text_speed)
    TextView mSpeed;

}
