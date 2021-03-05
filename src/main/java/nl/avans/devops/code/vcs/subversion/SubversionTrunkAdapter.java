package nl.avans.devops.code.vcs.subversion;

import nl.avans.devops.code.fs.Directory;
import nl.avans.devops.code.vcs.Branch;
import nl.avans.devops.code.vcs.Commit;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Random;

/**
 * In SVN, the main branch is a trunk.
 * The trunk can't have a custom name, so it doesn't match the branch interface.
 * This adapter makes sure we can use the trunk just like any other branch.
 */
class SubversionTrunkAdapter implements Branch {
    private final @NotNull SubversionTrunk trunk;

    SubversionTrunkAdapter(
            final @NotNull SubversionTrunk trunk
    ) {
        this.trunk = trunk;
    }

    @Override
    public long getId() {
        return trunk.getId();
    }

    @Override
    public @NotNull String getName() {
        return "Trunk";
    }

    @Override
    public @NotNull Commit getCommit() {
        return trunk.getCommit();
    }

    @Override
    public void applyChanges(final @NotNull Directory directory) {
        trunk.applyChanges(directory);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubversionTrunkAdapter subversionTrunkAdapter = (SubversionTrunkAdapter) o;
        return Objects.equals(trunk, subversionTrunkAdapter.trunk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trunk);
    }

    @Override
    public String toString() {
        return "SubversionBranchAdapter{name='" + getName() + "', head=" + trunk.getCommit() + ", id=" + trunk.getId() + "}";
    }
}