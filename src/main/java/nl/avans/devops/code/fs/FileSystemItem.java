package nl.avans.devops.code.fs;

import org.jetbrains.annotations.NotNull;

/**
 * File system composite.
 * Used so that a directory can contain multiple other directories and files,
 * without it having to "know" what it contains exactly.
 * @see Directory
 * @see File
 */
public interface FileSystemItem {
    @NotNull String getName();

    void setName(final @NotNull String name);
}
