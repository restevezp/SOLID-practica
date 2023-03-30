package com.kreitek.files;

import com.kreitek.interfaces.InterDirectory;
import com.kreitek.interfaces.InterFileSystemItem;

public abstract class FileSystemItemBase implements InterFileSystemItem {
    protected static final String PATH_SEPARATOR = "/";
    protected String name;
    protected InterDirectory parent;

    protected FileSystemItemBase(InterDirectory parent, String name) {
        setName(name);
        setParent(parent);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        }
       this.name = name;
    }

    @Override
    public InterDirectory getParent() {
        return parent;
    }

    @Override
    public void setParent(InterDirectory directory) {

            this.parent = directory;
    }

    @Override
    public String getFullPath() {
        String path = PATH_SEPARATOR;
        if (parent != null) {
            String parentFullPath = parent.getFullPath();
            path = parent.getFullPath() + (parentFullPath.length() > 1 ? PATH_SEPARATOR : "");
        }
        path = path + getName();
        return path;
    }

    @Override
    public abstract int getSize();

}
