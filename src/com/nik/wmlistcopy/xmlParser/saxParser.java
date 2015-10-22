package com.nik.wmlistcopy.xmlParser;

import org.xml.sax.AttributeList;
import org.xml.sax.HandlerBase;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.io.PrintWriter;
import java.util.ArrayList;

public class saxParser extends HandlerBase {
    private PrintWriter out;
    private int elements;
    private int attributes;
    private int characters;
    private int ignorableWhitespace;
    private String url;
    ArrayList<String> PathArray;

    public saxParser(String url_str) {
        url = url_str;
        PathArray = new ArrayList<>();
    }
    // =======================================================
    // Обработчики событий. Методы интерфейса DocumentHandler
    // ========================
    // Начало документа
    public void startDocument() {
        // Статистика
        elements            = 0;
        attributes          = 0;
        characters          = 0;
        ignorableWhitespace = 0;
        // Процессорные инструкции
        //out.println("");
    }
    // Конец документа
    public void endDocument() {
        //out.flush();
    }
    // Встретился открывающий тэг элемента //
    public void startElement(String name, AttributeList attrs) {

        if (attrs != null) {
            attributes += attrs.getLength();
        }
        // Печать тэга элемента вместе со списком его атрибутов,
        if ((attrs != null) && (name == "media")) {
            PathArray.add(attrs.getValue(0));
            elements++;
        }
    }
    // Встретился закрывающий тэг элемента
    public void endElement(String name) {
        //out.println("");
    }
    // Текстовые символы
    public void characters(char ch[], int start, int length) {
        characters += length;
        //out.println(new String(ch, start, length));
    }
    // Не обрабатываемые символы(например, содержимое секции CDATA)
    public void ignorableWhitespace(char ch[], int start, int length) {
        characters(ch, start, length);
    }
    // Инструкции XML-процессору(empty)
    public void processingInstruction(String target, String data) {}

    // ===================================================
    // Методы интерфейса ErrorHandler
    // ===============================
    // Последнее предупреждение
    public void warning(SAXParseException ex) {
        System.err.println("Warning at " + ex.getLineNumber() + " . " + ex.getColumnNumber() + "  -  "
                + ex.getMessage());
    }
    // Произошла ошибка
    public void error(SAXParseException ex) {
        System.err.println("Error at {" + ex.getLineNumber() + "." + ex.getColumnNumber() + "  -  " + ex.getMessage());
    }
    // Такие ошибки исправить уже нельзя
    public void fatalError(SAXParseException ex) throws SAXException {
        System.err.println("Fatal error at {" + ex.getLineNumber() + " . " + ex.getColumnNumber() + "  -  "
                + ex.getMessage());
        throw ex;
    }
    // =======================================================
    // Вывести информацию о документе
    // ===============================
    public void printInfo() {
        System.out.println();
        System.out.println("Документ " + url + " был успешно обработан");
        System.out.println("Элементов : " + elements);
        System.out.println("Атрибутов : " + attributes);
        System.out.println("Символов  : " + characters);
    }

    public ArrayList<String> getPathArray()
    {
        return PathArray;
    }
}
