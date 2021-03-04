package nl.avans.devops.code;

import nl.avans.devops.code.fs.Directory;
import nl.avans.devops.code.vcs.VersionControlSystem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.VisibleForTesting;

public class CodeRepository {
    private final @NotNull Directory projectRootDirectory;
    private final @NotNull VersionControlSystem versionControlSystem;

    public CodeRepository(
            final @NotNull VersionControlSystem versionControlSystem
    ) {
        this(new Directory(""), versionControlSystem);
    }

    @VisibleForTesting
    private CodeRepository(
            final @NotNull Directory projectRootDirectory,
            final @NotNull VersionControlSystem versionControlSystem
    ) {
        this.projectRootDirectory = projectRootDirectory;
        this.versionControlSystem = versionControlSystem;
    }

    public @NotNull Directory getProjectRootDirectory() {
        return projectRootDirectory;
    }

    public @NotNull VersionControlSystem getVersionControlSystem() {
        return versionControlSystem;
    }

    public void applyChanges() {
        getVersionControlSystem().getCheckedOutBranch().applyChanges(projectRootDirectory);
    }
}
