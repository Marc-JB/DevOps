package nl.avans.devops.code.vcs;

import nl.avans.devops.code.fs.Directory;
import org.jetbrains.annotations.NotNull;

public interface Branch {
    long getId();

    @NotNull String getName();

    @NotNull Commit getCommit();

    void applyChanges(@NotNull Directory directory);
}
