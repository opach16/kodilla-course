package com.kodilla.patterns.strategy.social;

public final class YGeneration extends User {

    public YGeneration(final String username) {
        super(username);
        this.socialPublisher = new FacebookPublisher();
    }
}
