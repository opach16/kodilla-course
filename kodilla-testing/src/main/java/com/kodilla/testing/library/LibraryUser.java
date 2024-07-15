package com.kodilla.testing.library;

public class LibraryUser {

    private String firstname;
    private String lastname;
    private int peselId;

    public LibraryUser(String firstname, String lastname, int peselId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.peselId = peselId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getPeselId() {
        return peselId;
    }

    public void setPeselId(int peselId) {
        this.peselId = peselId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LibraryUser that = (LibraryUser) o;
        return peselId == that.peselId && firstname.equals(that.firstname) && lastname.equals(that.lastname);
    }

    @Override
    public int hashCode() {
        int result = firstname.hashCode();
        result = 31 * result + lastname.hashCode();
        result = 31 * result + peselId;
        return result;
    }
}