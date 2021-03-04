package nl.avans.devops.code.vcs;

import org.jetbrains.annotations.NotNull;

import java.util.Set;

public interface VersionControlSystem {
    @NotNull Set<@NotNull Branch> getBranches();

    @NotNull Branch getDefaultBranch();

    @NotNull Branch getCheckedOutBranch();

    void addBranch(@NotNull Branch branch);

    void setCheckedOutBranch(@NotNull Branch branch);

    @NotNull Commit getHead();
}
