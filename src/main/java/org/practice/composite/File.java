package org.practice.composite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class File implements FileI {
    private static final Logger log = LoggerFactory.getLogger(File.class);
    int fileSize;
    String fileName;

    File(int fileSize, String fileName){
        this.fileSize = fileSize;
        this.fileName = fileName;
    }
    @Override
    public void displayInfo() {
        log.info("File Name {}",fileName);
    }

    @Override
    public int getSize() {
        return fileSize;
    }

}
