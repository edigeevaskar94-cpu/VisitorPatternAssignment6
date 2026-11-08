package filesystem.visitor;

import filesystem.model.Directory;
import filesystem.model.FileNode;

public class SizeCalculatorVisitor implements FileSystemVisitor {

    private long totalSize;

    @Override
    public void visitFile(FileNode file) {
        totalSize += file.getSize();
    }

    @Override
    public void visitDirectory(Directory directory) {
        // Directory itself does not have a file size.
    }

    public long getTotalSize() {
        return totalSize;
    }
}