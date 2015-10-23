package com.nik.wmlistcopy.gui;

import javax.swing.*;

/**
 * Created by nik on 23.10.2015.
 */
public class FileChooserPathSourcePathDestination {

    String ObjectPars, NewPath;

    public FileChooserPathSourcePathDestination()
    {
        int ret;
        try {
            JFileChooser fileopen = new JFileChooser();
            ret = fileopen.showDialog(null, "Открыть файл");
            ObjectPars = fileopen.getSelectedFile().getPath();

            fileopen = new JFileChooser();
            fileopen.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileopen.setAcceptAllFileFilterUsed(false);
            ret = fileopen.showDialog(null, "Открыть файл");
            NewPath = fileopen.getSelectedFile().getPath() + "\\";
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

    }

    public String getObjectPars() {
        return ObjectPars;
    }

    public String getNewPath() {
        return NewPath;
    }
}
