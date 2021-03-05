package nl.avans.devops.code.vcs;

import nl.avans.devops.code.vcs.subversion.SubversionBranch;
import nl.avans.devops.code.vcs.subversion.SubversionVCS;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SubversionVcsTests {
    @Test
    void creatingGitAddsDefaultBranch() {
        // Arrange/Act
        final @NotNull var vcs = new SubversionVCS();

        // Assert
        Assertions.assertEquals(1, vcs.getBranches().size());
    }

    @Test
    void creatingGitShouldMakeDefaultBranchCheckedOutBranch() {
        // Arrange/Act
        final @NotNull var vcs = new SubversionVCS();

        // Assert
        Assertions.assertEquals(vcs.getCheckedOutBranch(), vcs.getDefaultBranch());
    }

    @Test
    void addingNewBranchShouldNotChangeCheckedOutBranch() {
        // Arrange
        final @NotNull var vcs = new SubversionVCS();
        final @NotNull var devBranch = new SubversionBranch("dev");

        // Act
        vcs.addBranch(devBranch);

        // Assert
        Assertions.assertEquals(vcs.getCheckedOutBranch(), vcs.getDefaultBranch());
    }

    @Test
    void changingCheckedOutBranchShouldNotChangeDefaultBranch() {
        // Arrange
        final @NotNull var vcs = new SubversionVCS();
        final @NotNull var devBranch = new SubversionBranch("dev");
        vcs.addBranch(devBranch);

        // Act
        vcs.setCheckedOutBranch(devBranch);

        // Assert
        Assertions.assertNotEquals(vcs.getCheckedOutBranch(), vcs.getDefaultBranch());
    }
}
