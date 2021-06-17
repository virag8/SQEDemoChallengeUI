package com.sample.test.demo.utils;

import java.io.File;

public final class FileIO {
    private FileIO() {
    }

    public static void createDirectory(String directoryName) {
        File theDir = new File(directoryName);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
    }
}
