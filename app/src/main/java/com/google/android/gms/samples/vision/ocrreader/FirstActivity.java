package com.google.android.gms.samples.vision.ocrreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;

import java.util.Locale;


public class FirstActivity extends AppCompatActivity {
    private Button btnEnglish;
    private Button btnSpanish;
    private Button btnChinese;
    private Button btnHindi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        btnEnglish = findViewById(R.id.btnEnglish);
        btnChinese = findViewById(R.id.btnChinese);
        btnHindi = findViewById(R.id.btnHindi);
        btnSpanish = findViewById(R.id.btnSpanish);

        btnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.LANGUAGE = Utils.ENGLISH;
                Utils.LOCALE = Locale.US;
                launchOCR();
            }
        });

        btnChinese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.LANGUAGE = Utils.CHINESE;
                Utils.LOCALE = Locale.CHINA;
                launchOCR();
            }
        });

        btnSpanish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.LANGUAGE = Utils.SPANISH;
                Utils.LOCALE = new Locale("spa", "MEX");
                launchOCR();
            }
        });

        btnHindi.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Utils.LANGUAGE = Utils.HINDI;
                Utils.LOCALE = Locale.forLanguageTag("hin");
                launchOCR();
            }
        });
    }

    public void launchOCR() {
        startActivity(new Intent(getApplicationContext(), OcrOptions.class));
    }
}
