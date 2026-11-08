package filesystem.model;

import filesystem.visitor.FileSystemVisitor;

public class FileNode implements FileSystemElement {

    private final String name;
    private final long size;

    public FileNode(String name, long size) {
        this.name = name;

        if (size < 0) {
            throw new IllegalArgumentException("File size cannot be negative");
        }

        this.size = size;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visitFile(this);
    }
}