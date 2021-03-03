package nl.avans.devops;

import org.jetbrains.annotations.NotNull;

public class Project {
    private @NotNull String name;

    public Project(@NotNull String name) {
        this.name = name;
    }

    public @NotNull String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    @Override
    public @NotNull String toString() {
        return "Project{name='" + name + "'}";
    }
}
