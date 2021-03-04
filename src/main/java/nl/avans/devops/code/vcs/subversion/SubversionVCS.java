package nl.avans.devops.code.vcs.subversion;

import nl.avans.devops.code.vcs.Branch;
import nl.avans.devops.code.vcs.Commit;
import nl.avans.devops.code.vcs.VersionControlSystem;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class SubversionVCS implements VersionControlSystem {
    private final @NotNull Set<@NotNull Branch> branches;

    private final long defaultBranchId;

    private long checkedOutBranch;

    public SubversionVCS() {
        branches = new HashSet<>();
        final var defaultBranch = new SubversionTrunkAdapter(new SubversionTrunk());
        branches.add(defaultBranch);
        defaultBranchId = defaultBranch.getId();
        checkedOutBranch = defaultBranchId;
    }

    @Override
    public @NotNull Set<@NotNull Branch> getBranches() {
        return branches;
    }

    @Override
    public @NotNull Branch getDefaultBranch() {
        for(final @NotNull var branch : branches) {
            if (branch.getId() == defaultBranchId) {
                return branch;
            }
        }

        throw new IllegalStateException("There's no branch with default branch id of " + defaultBranchId);
    }

    @Override
    public @NotNull Branch getCheckedOutBranch() {
        for(final @NotNull var branch : branches) {
            if (branch.getId() == checkedOutBranch) {
                return branch;
            }
        }

        throw new IllegalStateException("There's no branch with default branch id of " + defaultBranchId);
    }

    @Override
    public void addBranch(@NotNull Branch branch) {
        branches.add(branch);
    }

    @Override
    public void setCheckedOutBranch(final @NotNull Branch branch) {
        if (!branches.contains(branch)) {
            throw new IllegalArgumentException("Branch with id " + branch.getId() + " is not a part of this repository.");
        }

        checkedOutBranch = branch.getId();
    }

    @Override
    public @NotNull Commit getHead() {
        return getCheckedOutBranch().getCommit();
    }
}
