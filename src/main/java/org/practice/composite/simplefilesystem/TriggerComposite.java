package org.practice.composite.simplefilesystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TriggerComposite {
    private static final Logger log = LoggerFactory.getLogger(TriggerComposite.class);
   public void runFileSystem()
    {
        FileI file1 = new File(1, "file1.xml");
        FileI file2 = new File(20, "file2.yml");

        //Sub Directory
        FileDirectory dirB = new FileDirectory("Dir_B");
        FileI file3 = new File(52, "file3.java");
        dirB.addComponent(file3);
        //Main Directory
        FileDirectory dirA = new FileDirectory("Dir_A");
        dirA.addComponent(file1);
        dirA.addComponent(file2);
        dirA.addComponent(dirB);
        log.info("Begining to Print File Name's");

//        FileI mainFile = new File(20,"Stratingfile.cpp")
//        mainFile.displayInfo();

        dirA.displayInfo();
        log.info("Size of the file {}", dirA.getSize());
        log.info("Successfully completed Composite pattern");

    }

}
