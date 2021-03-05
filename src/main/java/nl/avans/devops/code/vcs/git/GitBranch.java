package nl.avans.devops.code.vcs.git;

import nl.avans.devops.code.fs.Directory;
import nl.avans.devops.code.vcs.Branch;
import nl.avans.devops.code.vcs.Commit;
import org.jetbrains.annotations.NotNull;

import java.security.SecureRandom;
import java.util.Objects;

public class GitBranch implements Branch {
    private final @NotNull String name;

    private @NotNull Commit head;

    private final long id;

    public GitBranch(
            final @NotNull String name
    ) {
        this(name, new GitCommit());
    }

    public GitBranch(
            final @NotNull String name,
            final @NotNull Branch base
    ) {
        this(name, base.getCommit());
    }

    protected GitBranch(
            final @NotNull String name,
            final @NotNull Commit base
    ) {
        this.name = name;
        this.head = base;
        id = new SecureRandom().nextLong();
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public @NotNull String getName() {
        return name;
    }

    @Override
    public @NotNull Commit getCommit() {
        return head;
    }

    @Override
    public void applyChanges(final @NotNull Directory directory) {
        head = new GitCommit(head);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GitBranch gitBranch = (GitBranch) o;
        return id == gitBranch.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "GitBranch{name='" + name + "', head=" + head + ", id=" + id + "}";
    }
}