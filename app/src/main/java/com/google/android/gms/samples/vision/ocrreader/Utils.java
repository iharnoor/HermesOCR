package com.google.android.gms.samples.vision.ocrreader;

import android.util.SparseArray;

import com.google.android.gms.samples.vision.ocrreader.ui.camera.GasStation;
import com.google.android.gms.vision.text.TextBlock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public class Utils {
    public static String LANGUAGE = "hin";
    //    langEnumerator = {'eng': 0, 'hin': 1, 'chi': 2, 'spn': 3}
    public static String ENGLISH = "eng";
    public static String HINDI = "hin";
    public static String SPANISH = "spn";
    public static String CHINESE = "chi";
    public static Locale LOCALE = Locale.UK;

    public static String TEXTBLOCKARRAY;

    public static boolean isOutputReady = false;

    public static HashSet<Double> gasStations = new HashSet<>();
}
