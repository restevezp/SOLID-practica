package com.kreitek.service;

import com.kreitek.files.Directory;
import com.kreitek.files.File;
import com.kreitek.files.FileSystemItemBase;
import com.kreitek.files.error.InvalidFileFormatException;
import com.kreitek.interfaces.InterFileSystemItem;

import java.util.List;

public class FileManager {

    public static InterFileSystemItem convertMp3ToWav(File archivo) {
        if (!"mp3".equalsIgnoreCase(archivo.getExtension())) {
            throw new InvalidFileFormatException("El fichero debe ser mp3");
        }

        int indexOfLastDot = archivo.getName().lastIndexOf(".");
        String nameWithoutExtension = archivo.getName();
        if (indexOfLastDot > 0) {
            nameWithoutExtension = archivo.getName().substring(0, indexOfLastDot);
        }
        String newFileName = nameWithoutExtension + ".wav";
        File result = new File(archivo.getParent(), newFileName);
        result.open();
        // Lógica de conversión de mp3 a wav. Se lee de este fichero y se escribe en result
        result.close();
        return result;
    }

    public static InterFileSystemItem convertWavToMp3(File archivo) {
        if (!"wav".equalsIgnoreCase(archivo.getExtension())) {
            throw new InvalidFileFormatException("El fichero debe ser wav");
        }

        int indexOfLastDot = archivo.getName().lastIndexOf(".");
        String nameWithoutExtension = archivo.getName();
        if (indexOfLastDot > 0) {
            nameWithoutExtension = archivo.getName().substring(0, indexOfLastDot);
        }
        String newFileName = nameWithoutExtension + ".mp3";
        File result = new File(archivo.getParent(), newFileName);
        result.open();
        // Lógica de conversión de wav a mp3. Se lee de este fichero y se escribe en result
        result.close();
        return result;
    }


    public static int calculateSize(FileSystemItemBase fileSystemItem) {
        int totalSize = 0;

        if (fileSystemItem instanceof File) {
            totalSize = fileSystemItem.getSize();
        } else if (fileSystemItem instanceof Directory) {
            for (FileSystemItemBase item : ((Directory) fileSystemItem).listFiles()) {
                totalSize += calculateSize(item);
            }
        }

        return totalSize;
    }

    public static int calculateSize(List<FileSystemItemBase> files) {
        int totalSize = 0;

        for(FileSystemItemBase item : files) {
            if (item instanceof File) {
                totalSize += item.getSize();
            } else if (item instanceof Directory) {
                totalSize += calculateSize(((Directory) item).listFiles());
            }
        }

        return totalSize;
    }

    // Aquí habría otros métodos para gestionar ficheros y directorios:
    // Crear ficheros, mover ficheros, eliminar ficheros, etc.
}
