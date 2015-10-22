package com.nik.wmlistcopy.inputoutput;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

/**
 * Created by nik on 21.10.2015.
 */
public class CopyDateFromFilePath {

    public CopyDateFromFilePath(ArrayList<String> PathAndNameArray, String NewPath) throws IOException {
        int size = PathAndNameArray.size();

        Path pathSource ;
        Path pathDestination;

        for(int i = 0; i < size ; i+=2){

            pathSource = Paths.get(PathAndNameArray.get(i));
            pathDestination = Paths.get(NewPath + "\\" + PathAndNameArray.get(i+1));

            try {
                Files.copy(pathSource, pathDestination, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Copy:: " + pathSource + "\n" + "to" + "\n" + pathDestination + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}

