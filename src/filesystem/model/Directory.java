package filesystem.model;

import filesystem.visitor.FileSystemVisitor;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Directory implements FileSystemElement {

    private final String name;
    private final List<FileSystemElement> children = new ArrayList<>();

    public Directory(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public String getName() {
        return name;
    }

    public void addChild(FileSystemElement child) {
        children.add(Objects.requireNonNull(child));
    }

    public List<FileSystemElement> getChildren() {
        return List.copyOf(children);
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visitDirectory(this);

        for (FileSystemElement child : children) {
            child.accept(visitor);
        }
    }
}