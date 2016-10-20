package com.jure.flashlighttest;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public static Camera mCam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCam = Camera.open();
        Camera.Parameters p = mCam.getParameters();
        p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        mCam.setParameters(p);
        SurfaceTexture mPreviewTexture;
        mPreviewTexture = new SurfaceTexture(0);
        try {
            mCam.setPreviewTexture(mPreviewTexture);
        } catch (IOException ex) {
            // Ignore
        }
        mCam.startPreview();
    }
}
