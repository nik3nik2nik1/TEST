package com.nik.wmlistcopy.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by nik on 23.10.2015.
 */
public class WindowInformationOutOnTextArea extends JFrame {

    private JPanel p;
    private JTextArea text;
    private JScrollPane scrollPane;
    private Font BigFontTR;
    int x1 = 100, y1 = 100, x2 = 100, y2 = 200; // размеры окна вывода

    public WindowInformationOutOnTextArea(int x1, int y1, int x2, int y2) {
        // JFrame
        super("Выходная информация");
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        setBounds(x1, y1, x2, y2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // JPanel
        p = new JPanel();
        p.setLayout(null);
        // Font
        BigFontTR = new Font("TimesRoman", Font.BOLD,  16);
        // JTextArea
        text = new JTextArea();
        text.setFont(BigFontTR);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        // JScrollPane
        scrollPane = new JScrollPane(text);
        // Add objects
        p.add(scrollPane, BorderLayout.CENTER);
        add(p);
        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }

    public WindowInformationOutOnTextArea() {
        // JFrame
        super("Выходная информация");
        setBounds(x1, y1, x2, y2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // JPanel
        p = new JPanel();
        p.setLayout(null);
        // Font
        BigFontTR = new Font("TimesRoman", Font.BOLD,  16);
        // JTextArea
        text = new JTextArea();
        text.setFont(BigFontTR);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        // JScrollPane
        scrollPane = new JScrollPane(text);
        // Add objects
        p.add(scrollPane, BorderLayout.CENTER);
        add(p);
        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }

    public JTextArea getText() {
        return text;
    }
}
