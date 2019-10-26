package com.google.android.gms.samples.vision.ocrreader.Carl;// MedRef class handles all string references related to the medicines

import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class MedRef {
    HashMap<String, HashMap<String, String>> dict;
    // reads previously stored dictionary from memory

    public void loadDict(InputStream fi) {
        try {
            ObjectInputStream oi = new ObjectInputStream(fi);
            dict = (HashMap<String, HashMap<String, String>>) oi.readObject();
            Log.d("Read", "File Read successfully");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // takes string array from OCR and returns the string value of the medicine it found
    public String findMed(String[] arr) {
        for (String s : arr) {
            if (s.equals(""))
                continue;
            s = (s.charAt(0) + "").toUpperCase() + s.substring(1).toLowerCase();
            if (dict.containsKey(s)) {
                return s;
            }
        }
        return "Not Found";
    }

    public String findDescription(String med, String lang) {
        return dict.get(med).get(lang);
    }

}
