package nl.avans.devops;

import nl.avans.devops.code.CodeRepository;
import nl.avans.devops.code.vcs.git.GitVCS;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.VisibleForTesting;

public class Project {
    private @NotNull String name;
    private final @NotNull CodeRepository codeRepository;

    public Project(final @NotNull String name) {
        this(name, new CodeRepository(new GitVCS()));
    }

    @VisibleForTesting
    private Project(final @NotNull String name, final @NotNull CodeRepository codeRepository) {
        this.name = name;
        this.codeRepository = codeRepository;
    }

    public @NotNull String getName() {
        return name;
    }

    public void setName(final @NotNull String name) {
        this.name = name;
    }

    public @NotNull CodeRepository getCodeRepository() {
        return codeRepository;
    }

    @Override
    public @NotNull String toString() {
        return "Project{name='" + name + "'}";
    }
}
