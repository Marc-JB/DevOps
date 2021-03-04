package nl.avans.devops.code.fs;

import nl.avans.devops.code.fs.Directory;
import nl.avans.devops.code.fs.File;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DirectoryTests {
    @Test
    void removeChildShouldRemoveChildrenRecursively() {
        // Arrange
        final @NotNull var documentsDirectory = new Directory("Documents");
        final @NotNull var essaysDirectory = new Directory("Essays");
        essaysDirectory.addChild(new File("AvansDevOpsReport.docx"));
        essaysDirectory.addChild(new File("EnglishEssay.docx"));
        documentsDirectory.addChild(essaysDirectory);

        // Act
        documentsDirectory.removeChild(essaysDirectory);

        // Assert
        Assertions.assertEquals(0, documentsDirectory.getChildren().size());
        Assertions.assertEquals(0, essaysDirectory.getChildren().size());
    }

    @Test
    void removeAllChildrenShouldRemoveChildrenRecursively() {
        // Arrange
        final @NotNull var documentsDirectory = new Directory("Documents");
        final @NotNull var essaysDirectory = new Directory("Essays");
        essaysDirectory.addChild(new File("AvansDevOpsReport.docx"));
        essaysDirectory.addChild(new File("EnglishEssay.docx"));
        documentsDirectory.addChild(essaysDirectory);
        documentsDirectory.addChild(new Directory("Memes"));

        // Act
        documentsDirectory.removeAllChildren();

        // Assert
        Assertions.assertEquals(0, documentsDirectory.getChildren().size());
        Assertions.assertEquals(0, essaysDirectory.getChildren().size());
    }
}
