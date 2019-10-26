package com.google.android.gms.samples.vision.ocrreader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import android.os.Bundle;

public class BootCompletedReceiver extends BroadcastReceiver
{
  @Override
  public void onReceive(Context context, Intent intent)
  {
    // just create AlarmListAdapter and it will load alarms and start them
    new AlarmListAdapter(context);
  }
}

