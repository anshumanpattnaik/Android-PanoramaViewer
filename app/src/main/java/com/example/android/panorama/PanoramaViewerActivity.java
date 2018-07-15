package com.example.android.panorama;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import static com.example.android.panorama.MainActivity.PANO_RES_KEY_NAME;

public class PanoramaViewerActivity extends AppCompatActivity {

    private VrPanoramaView mVrPanoramaView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_panorama_viewer);
        getSupportActionBar().hide();

        mVrPanoramaView = (VrPanoramaView) findViewById(R.id.pano_viewer);

        Intent intent = getIntent();

        int panoRes = intent.getIntExtra(PANO_RES_KEY_NAME, 0);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), panoRes);

        mVrPanoramaView.loadImageFromBitmap(bitmap, null);
    }
}