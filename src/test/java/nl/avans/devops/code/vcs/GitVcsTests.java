package nl.avans.devops.code.vcs;

import nl.avans.devops.code.vcs.git.GitBranch;
import nl.avans.devops.code.vcs.git.GitVCS;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GitVcsTests {
    @Test
    void creatingGitAddsDefaultBranch() {
        // Arrange/Act
        final @NotNull var vcs = new GitVCS();

        // Assert
        Assertions.assertEquals(1, vcs.getBranches().size());
    }

    @Test
    void creatingGitWithCustomDefaultBranchNameAddsDefaultBranchWithCustomName() {
        // Arrange/Act
        final @NotNull var vcs = new GitVCS("dev");

        // Assert
        Assertions.assertEquals(1, vcs.getBranches().size());
        Assertions.assertEquals("dev", vcs.getDefaultBranch().getName());
    }

    @Test
    void creatingGitShouldMakeDefaultBranchCheckedOutBranch() {
        // Arrange/Act
        final @NotNull var vcs = new GitVCS();

        // Assert
        Assertions.assertEquals(vcs.getCheckedOutBranch(), vcs.getDefaultBranch());
    }

    @Test
    void addingNewBranchShouldNotChangeCheckedOutBranch() {
        // Arrange
        final @NotNull var vcs = new GitVCS();
        final @NotNull var devBranch = new GitBranch("dev");

        // Act
        vcs.addBranch(devBranch);

        // Assert
        Assertions.assertEquals(vcs.getCheckedOutBranch(), vcs.getDefaultBranch());
    }

    @Test
    void changingCheckedOutBranchShouldNotChangeDefaultBranch() {
        // Arrange
        final @NotNull var vcs = new GitVCS();
        final @NotNull var devBranch = new GitBranch("dev");
        vcs.addBranch(devBranch);

        // Act
        vcs.setCheckedOutBranch(devBranch);

        // Assert
        Assertions.assertNotEquals(vcs.getCheckedOutBranch(), vcs.getDefaultBranch());
    }
}
