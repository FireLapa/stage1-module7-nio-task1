package com.epam.mjc.nio;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Arrays;

public class FileReader {

    public Profile getDataFromFile(File file) {
        int content;
        String[] x = new String[8];
        StringBuilder sb = new StringBuilder();
        try (InputStream inputStream = Files.newInputStream(file.toPath())) {
            do {
                content = inputStream.read();
                if (content != -1) {
                    sb.append((char)content);
                }
            } while (content != -1);
            String text = sb.toString();
            x = text.split("\r?\n|\r|: ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Profile(x[1], Integer.valueOf(x[3]), x[5], Long.valueOf(x[7]));
    }
}
