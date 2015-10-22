package com.nik.wmlistcopy.inputoutput;

import java.io.*;
import java.util.ArrayList;

public class ReadFile {

    private ArrayList<String> StringArray;

    public ReadFile(String path)
    {
        // Чтение из файла
        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            String value;
            StringArray = new ArrayList<>();
            while ((value = in.readLine()) != null) {
                StringArray.add(value);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<String> getStringArray() {
        return StringArray;
    }
}
