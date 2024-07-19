package org.practice.composite.unixfilesearch;

public interface IEntry {
    String getName();

    void setName(String name);

    int getSize();

    boolean isDirectory();
}
