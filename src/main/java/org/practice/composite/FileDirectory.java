package org.practice.composite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class FileDirectory implements FileI {
    private static final Logger log = LoggerFactory.getLogger(FileDirectory.class);
    private String dirName;
    public List<FileI> fileIList = new ArrayList<>();

    public FileDirectory(String dirName) {
        this.dirName = dirName;
    }


    @Override
    public void displayInfo() {
        log.info("File Directory : {}",dirName);
        for(FileI fileI : fileIList){
            fileI.displayInfo();
        }
    }

    @Override
    public int getSize() {
        int size=0;
        for(FileI fileI : fileIList){
            size+= fileI.getSize();
        }
        return size;
    }


    public void addComponent(FileI fileI){
        fileIList.add(fileI);
    }

    public void removeComponent(FileI fileI){
        this.fileIList.remove(fileI);
    }
}
