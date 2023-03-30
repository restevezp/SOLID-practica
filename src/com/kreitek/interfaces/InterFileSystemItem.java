package com.kreitek.interfaces;

public interface InterFileSystemItem {
    String getName();

    void setName(String name);

    InterDirectory getParent();

    void setParent(InterDirectory directory);

    String getFullPath();

    int getSize();

}
