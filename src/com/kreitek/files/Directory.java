package com.kreitek.files;

import com.kreitek.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystemItemBase implements InterFileSystemItem, InterDirectory {

   // private static final String NO_ES_VALIDO_PARA_DIRECTORIOS = "No es válido para directorios";
    private final List<FileSystemItemBase> files;

    public Directory(InterDirectory parent, String name) {
        super(parent, name);
        files = new ArrayList<>();
        // Aquí vendría lógica que rellena la lista de ficheros
    }

    @Override
    public List<FileSystemItemBase> listFiles() {
        return files;
    }

    @Override
    public void addFile(FileSystemItemBase file) {
        if (!files.contains(file)) {
            files.add(file);
            file.setParent(this);
        }
    }

    @Override
    public void removeFile(FileSystemItemBase file) {
        files.remove(file);
    }

    @Override
    public int getSize() {
        //throw new UnsupportedOperationException(NO_ES_VALIDO_PARA_DIRECTORIOS);

        int size = 0;
        for (FileSystemItemBase file : files) {
            size += file.getSize();
        }
        return size;
    }


}
