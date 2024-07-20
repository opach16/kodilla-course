package com.kodilla.stream.portfolio;

import java.time.LocalDate;

public final class Task {

    private final String title;
    private final String description;
    private final User asignedUser;
    private final User creator;
    private final LocalDate created;
    private final LocalDate deadline;

    public Task(final String title, final String description, final User asignedUser, final User creator, final LocalDate created, final LocalDate deadline) {
        this.title = title;
        this.description = description;
        this.asignedUser = asignedUser;
        this.creator = creator;
        this.created = created;
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public User getAsignedUser() {
        return asignedUser;
    }

    public User getCreator() {
        return creator;
    }

    public LocalDate getCreated() {
        return created;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", asignedUser=" + asignedUser +
                ", creator=" + creator +
                ", created=" + created +
                ", deadline=" + deadline +
                '}';
    }
}
