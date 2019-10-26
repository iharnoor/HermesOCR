package com.google.android.gms.samples.vision.ocrreader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.samples.vision.ocrreader.Carl.MedRef;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class DictionaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        MedRef mr = new MedRef();

        try {
            InputStream fis = this.getAssets().open("meddict.dictobj");
            mr.loadDict(fis);
            String[] arr = {"spoon", "Excedrin"};
            String med = mr.findMed(arr);
            System.out.println(mr.findDescription(med, "eng"));
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
