package com.nik.wmlistcopy.StringProcessing;

import java.util.ArrayList;

/**
 * Created by nik on 22.10.2015.
 */
public class StringCircumcision {

    ArrayList<String> PathAndNameArray;

    public StringCircumcision(ArrayList<String> PathArray)
    {
        PathAndNameArray = new ArrayList<>();

        int size = PathArray.size();
        int FirsIndex, LastIndex;
        for(int i = 0; i < size ; i++){

            FirsIndex = PathArray.get(i).lastIndexOf('\\') + 1;
            LastIndex = PathArray.get(i).length();
            //Добавление всего пути
            PathAndNameArray.add(PathArray.get(i));
            //Добавление имени файла
            PathAndNameArray.add(PathArray.get(i).substring(FirsIndex, LastIndex));

            //System.out.println(PathArray.get(i));
            //System.out.println(PathArray.get(i).substring(FirsIndex, LastIndex));

        }
    }

    public ArrayList<String> getPathAndNameArray()
    {
        return PathAndNameArray;
    }



}
