package nl.avans.devops.code.fs;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Directory extends FileSystemItem implements Iterable<@NotNull FileSystemItem> {
    private @NotNull String name;
    private final @NotNull Set<@NotNull FileSystemItem> children;

    public Directory(final @NotNull String name) {
        this.name = name;
        this.children = new HashSet<>();
    }

    @Override
    public @NotNull String getName() {
        return name;
    }

    @Override
    public void setName(final @NotNull String name) {
        this.name = name;
    }

    public @NotNull Set<@NotNull FileSystemItem> getChildren() {
        return children;
    }

    @Override
    public @NotNull Iterator<@NotNull FileSystemItem> iterator() {
        return children.iterator();
    }

    public void addChild(final @NotNull FileSystemItem fileSystemItem) {
        children.add(fileSystemItem);
    }

    public void removeChild(final @NotNull FileSystemItem fileSystemItem) {
        if(fileSystemItem instanceof Directory) {
            final @NotNull var directory = (Directory) fileSystemItem;
            directory.removeAllChildren();
        }

        children.remove(fileSystemItem);
    }

    public void removeAllChildren() {
        final @NotNull var iterator = children.iterator();
        while (iterator.hasNext()) {
            final @NotNull var next = iterator.next();
            if(next instanceof Directory) {
                final @NotNull var directory = (Directory) next;
                directory.removeAllChildren();
            }

            iterator.remove();
        }
    }

    @Override
    public @NotNull String toString() {
        return "Directory{name='" + name + "'}";
    }
}
