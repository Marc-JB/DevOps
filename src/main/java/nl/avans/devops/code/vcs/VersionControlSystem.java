package nl.avans.devops.code.vcs;

import org.jetbrains.annotations.NotNull;

import java.util.Set;

/**
 * This interfaces allows a user to choose a VCS strategy, like Git or SVN.
 * @see nl.avans.devops.code.vcs.subversion.SubversionVCS
 * @see nl.avans.devops.code.vcs.git.GitVCS
 */
public interface VersionControlSystem {
    @NotNull Set<@NotNull Branch> getBranches();

    @NotNull Branch getDefaultBranch();

    @NotNull Branch getCheckedOutBranch();

    void addBranch(@NotNull Branch branch);

    void setCheckedOutBranch(@NotNull Branch branch);

    @NotNull Commit getHead();
}
