package com.google.android.gms.samples.vision.ocrreader;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OcrOutputActivity extends AppCompatActivity {


    private TextView tvOutput;
    private static String KEY_EXTRA = "medDesc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocr_output);

        String outputStr = null;
//        tvOutput = findViewById(R.id.outputStrtvOutput);
//
//        if (getIntent().hasExtra(KEY_EXTRA)) {
//            outputStr = getIntent().getStringExtra(KEY_EXTRA);
//            tvOutput.setText(outputStr);
//        } else {
//            throw new IllegalArgumentException("Activity cannot find  extras " + KEY_EXTRA);
//        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), OcrOptions.class));
                finish();
            }
        }, 6500);
    }
}
