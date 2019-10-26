package com.google.android.gms.samples.vision.ocrreader;

import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import android.util.Log;
import android.content.Context;

public class DataSource
{
  private static final String TAG = "AlarmMe";

  private static final DataSource mDataSource = new DataSource();
  private static Context mContext = null;
  private static ArrayList<Alarm> mList = null;
  private static long mNextId;

  private static final String DATA_FILE_NAME = "alarmme.txt";
  private static final long MAGIC_NUMBER = 0x54617261646f7641L;

  protected DataSource()
  {
  }

  public static synchronized DataSource getInstance(Context context)
  {
    if (mContext == null)
    {
      mContext = context.getApplicationContext();
      load();
    }
    return mDataSource;
  }

  private static void load()
  {
    Log.i(TAG, "DataSource.load()");

    mList = new ArrayList<Alarm>();
    mNextId = 1;

    try
    {
      DataInputStream dis = new DataInputStream(mContext.openFileInput(DATA_FILE_NAME));
      long magic = dis.readLong();
      int size;

      if (MAGIC_NUMBER == magic)
      {
        mNextId = dis.readLong();
        size = dis.readInt();

        for (int i = 0; i < size; i++)
        {
          Alarm alarm = new Alarm(mContext);
          alarm.deserialize(dis);
          mList.add(alarm);
        }
      }

      dis.close();
    } catch (IOException e)
    {
    }
  }

  public static void save()
  {
    Log.i(TAG, "DataSource.save()");

    try
    {
      DataOutputStream dos = new DataOutputStream(mContext.openFileOutput(DATA_FILE_NAME, Context.MODE_PRIVATE));

      dos.writeLong(MAGIC_NUMBER);
      dos.writeLong(mNextId);
      dos.writeInt(mList.size());

      for (int i = 0; i < mList.size(); i++)
        mList.get(i).serialize(dos);

      dos.close();
    } catch (IOException e)
    {
    }
  }

  public static int size()
  {
    return mList.size();
  }

  public static Alarm get(int position)
  {
    return mList.get(position);
  }

  public static void add(Alarm alarm)
  {
    alarm.setId(mNextId++);
    mList.add(alarm);
    Collections.sort(mList);
    save();
  }

  public static void remove(int index)
  {
    mList.remove(index);
    save();
  }

  public static void update(Alarm alarm)
  {
    alarm.update();
    Collections.sort(mList);
    save();
  }

  public static long getNextId()
  {
    return mNextId;
  }
}

