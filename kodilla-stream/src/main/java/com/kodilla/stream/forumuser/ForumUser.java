package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class ForumUser {
    private final int id;
    private final String username;
    private final char gender;
    private final LocalDate dateOfBirth;
    private final int numberOfPosts;

    public ForumUser(final int id, final String username, final char gender, final String dateOfBirth, final int numberOfPosts) {
        this.id = id;
        this.username = username;
        this.gender = gender;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dateOfBirth = LocalDate.parse(dateOfBirth, formatter);
        this.numberOfPosts = numberOfPosts;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForumUser forumUser = (ForumUser) o;
        return id == forumUser.id && gender == forumUser.gender && numberOfPosts == forumUser.numberOfPosts && username.equals(forumUser.username) && dateOfBirth.equals(forumUser.dateOfBirth);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + username.hashCode();
        result = 31 * result + gender;
        result = 31 * result + dateOfBirth.hashCode();
        result = 31 * result + numberOfPosts;
        return result;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", numberOfPosts=" + numberOfPosts +
                '}';
    }
}