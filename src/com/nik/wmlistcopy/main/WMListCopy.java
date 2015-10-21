package com.nik.wmlistcopy.main;

import com.nik.wmlistcopy.inputoutput.ReadFile;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by nik on 21.10.2015.
 */
public class WMListCopy {

    public static void main(String[] args ) throws IOException {

        // C:\Users\nik\Music\Playlists\1.wpl

        ArrayList<String> StringArray = new ReadFile("C:\\Users\\nik\\Music\\Playlists\\1.wpl").getStringArray();

        System.out.println("xxx");

    }

}
