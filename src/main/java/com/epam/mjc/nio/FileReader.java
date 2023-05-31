package com.epam.mjc.nio;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class FileReader {

    public Profile getDataFromFile(File file) {
        int content;
        String[] x = new String[8];
        String text = new String();
        try (InputStream inputStream = Files.newInputStream(file.toPath())) {
            do {
                content = inputStream.read();
                if (content != -1) {
                    text = text + (char) content;
                }
            } while (content != -1);
            x = text.split("\r?\n|\r|: ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Profile(x[1], Integer.valueOf(x[3]), x[5], Long.valueOf(x[7]));
    }
}
