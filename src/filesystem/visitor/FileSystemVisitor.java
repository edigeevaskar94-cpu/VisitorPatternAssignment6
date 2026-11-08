package filesystem.visitor;

import filesystem.model.FileNode;
import filesystem.model.Directory;

public interface FileSystemVisitor {

    void visitFile(FileNode file);

    void visitDirectory(Directory directory);
}