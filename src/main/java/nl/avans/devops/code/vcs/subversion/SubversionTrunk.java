package nl.avans.devops.code.vcs.subversion;

import nl.avans.devops.code.fs.Directory;
import nl.avans.devops.code.vcs.Branch;
import nl.avans.devops.code.vcs.Commit;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Random;

public class SubversionTrunk {
    private @NotNull Commit head;

    private final long id;

    SubversionTrunk() {
        this(new SubversionCommit());
    }

    SubversionTrunk(final @NotNull Branch base) {
        this(base.getCommit());
    }

    protected SubversionTrunk(final @NotNull Commit base) {
        this.head = base;
        id = new Random().nextLong();
    }

    public long getId() {
        return id;
    }

    public @NotNull Commit getCommit() {
        return head;
    }

    public void applyChanges(final @NotNull Directory directory) {
        head = new SubversionCommit(head);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubversionTrunk subversionTrunkAdapter = (SubversionTrunk) o;
        return id == subversionTrunkAdapter.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "SubversionTrunk{head=" + head + ", id=" + id + "}";
    }
}