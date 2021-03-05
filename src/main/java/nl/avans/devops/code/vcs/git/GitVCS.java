package nl.avans.devops.code.vcs.git;

import nl.avans.devops.code.vcs.Branch;
import nl.avans.devops.code.vcs.Commit;
import nl.avans.devops.code.vcs.VersionControlSystem;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class GitVCS implements VersionControlSystem {
    private final @NotNull Set<@NotNull Branch> branches;

    private final long defaultBranchId;

    private long checkedOutBranch;

    public GitVCS() {
        this("main");
    }

    public GitVCS(final @NotNull String defaultBranchName) {
        branches = new HashSet<>();
        final var defaultBranch = new GitBranch(defaultBranchName);
        branches.add(defaultBranch);
        defaultBranchId = defaultBranch.getId();
        checkedOutBranch = defaultBranchId;
    }

    @Override
    public @NotNull Set<@NotNull Branch> getBranches() {
        return branches;
    }

    private @NotNull Branch getBranchById(final long id) {
        for(final @NotNull var branch : branches) {
            if (branch.getId() == id) {
                return branch;
            }
        }

        throw new IllegalStateException("There's no branch with default branch id of " + defaultBranchId);
    }

    @Override
    public @NotNull Branch getDefaultBranch() {
        return getBranchById(defaultBranchId);
    }

    @Override
    public @NotNull Branch getCheckedOutBranch() {
        return getBranchById(checkedOutBranch);
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
