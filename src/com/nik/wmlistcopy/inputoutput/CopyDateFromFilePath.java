package com.nik.wmlistcopy.inputoutput;


import com.nik.wmlistcopy.gui.WindowInformationOutOnTextArea;

import javax.swing.*;
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
        // Переменные
        int size = PathAndNameArray.size();
        int x1 = 100, y1 = 100, x2 = 1500, y2 = 500; // размеры окна вывода
        Path pathSource;
        Path pathDestination;
        JTextArea text;
        int CopySyze = 0;
        // Создание окна и получение JTextArea компонента
        WindowInformationOutOnTextArea Window = new WindowInformationOutOnTextArea(x1, y1, x2, y2);
        text = Window.getText();
        // Копирование
        for(int i = 0; i < size ; i+=2){
            // Конвертирование путей
            pathSource = Paths.get(PathAndNameArray.get(i));
            pathDestination = Paths.get(NewPath + "\\" + PathAndNameArray.get(i+1));
            // Копирование и вывод
            try {
                Files.copy(pathSource, pathDestination, StandardCopyOption.REPLACE_EXISTING);
                text.append("\nCopy:: " + pathSource + "\n" + "to" + "\n" + pathDestination + "\n");
                CopySyze++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        text.append("\n" + String.valueOf(CopySyze) + "\n");
    }
}

