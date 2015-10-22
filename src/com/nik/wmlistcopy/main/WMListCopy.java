package com.nik.wmlistcopy.main;

import com.nik.wmlistcopy.StringProcessing.StringCircumcision;
import com.nik.wmlistcopy.inputoutput.CopyDateFromFilePath;
import com.nik.wmlistcopy.xmlParser.saxParser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by nik on 21.10.2015.
 */
public class WMListCopy {



    public static void main(String[] args) throws IOException {

        ArrayList<String> PathAndNameArray;
        String NewPath = "E:\\ms";

        try {

            String ObjectPars = "C:\\Users\\nik\\IntelliJ_IDEA\\TEST\\out\\artifacts\\TEST_jar\\1.wpl";
            // Инициализация обработчика xml
            saxParser sample = new saxParser(ObjectPars);
            //Определяет API фабрики, который позволяет приложениям сконфигурировать и получить SAX базируемый
            //синтаксический анализатор, чтобы проанализировать XML-документы.
            SAXParserFactory factory = SAXParserFactory.newInstance();
            //Создает новый экземпляр SAXParser использование в настоящий момент сконфигурированных параметров фабрики.
            SAXParser saxParser = factory.newSAXParser();
            // Добавление пати к файлу(ObjectPars) и обработчика(sample)
            saxParser.parse(ObjectPars, sample);
            // Вывод результатов
            sample.printInfo();
            // Отделение имени файла от его пути
            PathAndNameArray = new StringCircumcision(sample.getPathArray()).getPathAndNameArray();
            //Копирование файлов
            new CopyDateFromFilePath(PathAndNameArray, NewPath);

        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

    }

}
