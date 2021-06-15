package com.sample.test.demo.utils;

import java.io.File;

public final class FileIO {
    public static void CreateDirectory(String directoryName) {
        File theDir = new File(directoryName);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
    }
}
