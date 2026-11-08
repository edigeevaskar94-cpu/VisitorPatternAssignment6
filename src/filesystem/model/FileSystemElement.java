package filesystem.model;

import filesystem.visitor.FileSystemVisitor;

public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}