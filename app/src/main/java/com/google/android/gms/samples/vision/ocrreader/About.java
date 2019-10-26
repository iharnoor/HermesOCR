package com.google.android.gms.samples.vision.ocrreader;

import android.widget.TextView;
import android.app.Activity;
import android.os.Bundle;

public class About extends Activity {
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.about);

        long nextId = DataSource.getInstance(null).getNextId() - 1;

        mTextView = (TextView) findViewById(R.id.alarms_created_text);
        mTextView.setText("Alarms created: " + nextId);
    }
}

