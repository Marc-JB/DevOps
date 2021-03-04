package nl.avans.devops.code.fs;

import org.jetbrains.annotations.NotNull;

public abstract class FileSystemItem {
    public abstract @NotNull String getName();

    public abstract void setName(final @NotNull String name);
}
