package nl.avans.devops.code.vcs;

import nl.avans.devops.code.fs.Directory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface Commit {
    long getId();

    @Nullable Commit getParent();

    void applyDiff(@NotNull Directory directory);
}
