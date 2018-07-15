package com.example.android.panorama;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mPanoList;

    private ArrayList<Integer> mPanoramaList;

    private PanoramaAdapter mAdapter;

    public static final String PANO_RES_KEY_NAME = "pano_res_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPanoList = (RecyclerView) findViewById(R.id.panorama_list);

        mPanoramaList = new ArrayList<>();

        int panorama1 = R.drawable.panorama1;
        int panorama2 = R.drawable.panorama2;
        int panorama3 = R.drawable.panorama3;
        int panorama4 = R.drawable.panorama4;
        int panorama5 = R.drawable.panorama5;
        int panorama6 = R.drawable.panorama6;
        int panorama7 = R.drawable.panorama7;
        int panorama8 = R.drawable.panorama8;
        int panorama9 = R.drawable.panorama9;
        int panorama10 = R.drawable.panorama10;

        mPanoramaList.add(panorama1);
        mPanoramaList.add(panorama2);
        mPanoramaList.add(panorama3);
        mPanoramaList.add(panorama4);
        mPanoramaList.add(panorama5);
        mPanoramaList.add(panorama6);
        mPanoramaList.add(panorama7);
        mPanoramaList.add(panorama8);
        mPanoramaList.add(panorama9);
        mPanoramaList.add(panorama10);

        mAdapter = new PanoramaAdapter(this, mPanoramaList, listener);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        mPanoList.setLayoutManager(mLayoutManager);
        mPanoList.setItemAnimator(new DefaultItemAnimator());
        mPanoList.setNestedScrollingEnabled(false);
        mPanoList.setAdapter(mAdapter);
    }

    private IPanoramaClickListener listener = new IPanoramaClickListener() {
        @Override
        public void onClick(int poisition) {
            Intent intent = new Intent(MainActivity.this, PanoramaViewerActivity.class);
            intent.putExtra(PANO_RES_KEY_NAME, mPanoramaList.get(poisition));
            startActivity(intent);
        }
    };
}