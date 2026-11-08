package filesystem.visitor;

import filesystem.model.Directory;
import filesystem.model.FileNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SearchVisitor implements FileSystemVisitor {

    private final String searchTerm;
    private final List<FileNode> matchingFiles = new ArrayList<>();

    public SearchVisitor(String searchTerm) {
        if (searchTerm == null || searchTerm.isBlank()) {
            throw new IllegalArgumentException("Search term cannot be empty");
        }

        this.searchTerm = searchTerm.toLowerCase(Locale.ROOT);
    }

    @Override
    public void visitFile(FileNode file) {
        if (file.getName().toLowerCase(Locale.ROOT).contains(searchTerm)) {
            matchingFiles.add(file);
        }
    }

    @Override
    public void visitDirectory(Directory directory) {
        // Directory traversal is handled by Directory.accept().
    }

    public List<FileNode> getMatchingFiles() {
        return List.copyOf(matchingFiles);
    }
}