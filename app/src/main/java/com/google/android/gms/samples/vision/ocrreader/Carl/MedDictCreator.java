package com.google.android.gms.samples.vision.ocrreader.Carl;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MedDictCreator implements Serializable {
    private String jsonFile = "C:\\Users\\Carl Wilhjelm\\Documents\\GitHub\\PharmaPal2\\ocr-reader-start\\app\\src\\main\\res\\raw\\meddict.json";
    private String objFilePath = "C:\\Users\\Carl Wilhjelm\\Documents\\GitHub\\PharmaPal2\\ocr-reader-start\\app\\src\\main\\java\\meddict.dictobj";
    private String[] langs = new String[] {"eng", "chi", "hin", "spn"};

    public String getObjFilePath(){
        return objFilePath;
    }

    public boolean dictCreator() {

        // create the Hashmap obj to be used in the app
        Map<String, Map<String, String>> dict = new HashMap<String, Map<String, String>>();
        // declare the hashmap of langs to be mapped to each string of medicine
        Map<String, String> langsMap;
        JSONObject obj;
        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(jsonFile);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // each line in the json file references a separate json object for each medicine
            while((line = bufferedReader.readLine()) != null) {
                obj = (JSONObject) new JSONParser().parse(line);
                langsMap = new HashMap<String, String>();
                for (String l: langs){
                    langsMap.put(l, (String) obj.get(l));
                }
                dict.put((String) obj.get("name"), langsMap);
            }
            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + jsonFile + "'");
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + jsonFile + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return writeObjToFile(dict);
    }

    // save the dictionary object
    public boolean writeObjToFile(Map<String, Map<String, String>> dictIn){
        try {

            FileOutputStream fileOut = new FileOutputStream(objFilePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(dictIn);
            objectOut.close();
            System.out.println("The Object was successfully written to a file");
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}

