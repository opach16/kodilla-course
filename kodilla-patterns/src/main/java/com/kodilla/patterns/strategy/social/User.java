package com.kodilla.patterns.strategy.social;

public sealed class User
        permits Millenials, YGeneration, ZGeneration {

    private final String username;
    protected SocialPublisher socialPublisher;

    public User(final String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String sharePost() {
        return socialPublisher.share();
    }

    public void setSocialPublisher(final SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }
}
