package filesystem.app;

import filesystem.model.Directory;
import filesystem.model.FileNode;
import filesystem.visitor.SearchVisitor;
import filesystem.visitor.SizeCalculatorVisitor;

public class Main {

    public static void main(String[] args) {

        // Create the file system structure
        Directory root = new Directory("Root");

        root.addChild(new FileNode("README.md", 120));
        root.addChild(new FileNode("annual_report.pdf", 1500));

        Directory documents = new Directory("Documents");
        documents.addChild(new FileNode("project_report.docx", 800));
        documents.addChild(new FileNode("notes.txt", 300));

        Directory images = new Directory("Images");
        images.addChild(new FileNode("logo.png", 450));

        root.addChild(documents);
        root.addChild(images);

        // Visitor 1: Calculate total file size
        SizeCalculatorVisitor sizeVisitor =
                new SizeCalculatorVisitor();

        root.accept(sizeVisitor);

        System.out.println("=== Size Calculator Visitor ===");
        System.out.println(
                "Total size: " + sizeVisitor.getTotalSize() + " bytes"
        );

        // Visitor 2: Search files by name
        SearchVisitor searchVisitor =
                new SearchVisitor("report");

        root.accept(searchVisitor);

        System.out.println("\n=== Search Visitor ===");
        System.out.println("Files matching 'report':");

        for (FileNode file : searchVisitor.getMatchingFiles()) {
            System.out.println(
                    "- " + file.getName() + " (" +
                            file.getSize() + " bytes)"
            );
        }

        System.out.println(
                "Total matches: " +
                        searchVisitor.getMatchingFiles().size()
        );
    }
}