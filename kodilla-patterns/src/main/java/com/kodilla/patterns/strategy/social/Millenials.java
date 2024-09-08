package com.kodilla.patterns.strategy.social;

public final class Millenials extends User {

    public Millenials(final String username) {
        super(username);
        this.socialPublisher = new TwitterPublisher();
    }
}
