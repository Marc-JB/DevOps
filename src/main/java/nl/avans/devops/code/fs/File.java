package nl.avans.devops.code.fs;

import org.jetbrains.annotations.NotNull;

public class File extends FileSystemItem {
    private @NotNull String name;
    private @NotNull String contents;

    public File(final @NotNull String name) {
        this(name, "");
    }

    public File(final @NotNull String name, final @NotNull String contents) {
        this.name = name;
        this.contents = contents;
    }

    @Override
    public @NotNull String getName() {
        return name;
    }

    @Override
    public void setName(final @NotNull String name) {
        this.name = name;
    }

    public @NotNull String getContents() {
        return contents;
    }

    public void setContents(final @NotNull String contents) {
        this.contents = contents;
    }

    @Override
    public @NotNull String toString() {
        return "File{name='" + name + "'}";
    }
}
