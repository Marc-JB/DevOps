package nl.avans.devops.code.vcs.git;

import nl.avans.devops.code.fs.Directory;
import nl.avans.devops.code.vcs.Commit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Random;

public class GitCommit implements Commit {
    private final @Nullable Commit parent;

    private final long id;

    public GitCommit() {
        parent = null;
        id = new Random().nextLong();
    }

    public GitCommit(final @NotNull Commit parent) {
        this.parent = parent;
        id = new Random().nextLong();
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public @Nullable Commit getParent() {
        return parent;
    }

    @Override
    public void applyDiff(@NotNull Directory directory) {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GitCommit gitCommit = (GitCommit) o;
        return id == gitCommit.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "GitCommit{parent=" + (parent != null ? parent.getId() : 0) + ", id=" + id + "}";
    }
}