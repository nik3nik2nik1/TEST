package com.nik.wmlistcopy.main;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

// =======================================================
// Обработка XML документа
// ========================
public class saxSample {
    public static void main(String argv[]) {
        try {

            String ObjectPars = "C:\\Users\\nik\\IntelliJ_IDEA\\TEST\\out\\artifacts\\TEST_jar\\1.wpl";

            saxParser sample = new saxParser(ObjectPars);
            // так не правельно
            // Parser parser = ParserFactory.makeParser("com.ibm.xml.parsers.SAXParser");
            // parser.setDocumentHandler(sample);
            // parser.setErrorHandler(sample);
            // parser.parse(argv[0]);

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(ObjectPars, sample);
            sample.printInfo();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}