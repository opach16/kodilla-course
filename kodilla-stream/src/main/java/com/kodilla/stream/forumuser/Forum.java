package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> listOfUsers = new ArrayList<>();

    public Forum() {
        listOfUsers.add(new ForumUser(0001, "user1", 'M', "11/04/1994", 5));
        listOfUsers.add(new ForumUser(0002, "user2", 'M', "01/12/1992", 0));
        listOfUsers.add(new ForumUser(0003, "user3", 'F', "15/11/1985", 54));
        listOfUsers.add(new ForumUser(0004, "user4", 'F', "30/08/1953", 4));
        listOfUsers.add(new ForumUser(0005, "user5", 'M', "02/03/1999", 18));
        listOfUsers.add(new ForumUser(0006, "user6", 'F', "19/05/2001", 0));
        listOfUsers.add(new ForumUser(0007, "user7", 'M', "15/07/2006", 23));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(listOfUsers);
    }
}