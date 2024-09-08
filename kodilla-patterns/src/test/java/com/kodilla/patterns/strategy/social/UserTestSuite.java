package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //given
        User mike = new Millenials("Mike");
        User steven = new YGeneration("Steven");
        User charlie = new ZGeneration("Charlie");

        //when
        String mikeSharedPost = mike.sharePost();
        String stevenSharedPost = steven.sharePost();
        String charlieSharedPost = charlie.sharePost();

        //then
        System.out.println(mike.getUsername() + ": " + mikeSharedPost);
        System.out.println(steven.getUsername() + ": " + stevenSharedPost);
        System.out.println(charlie.getUsername() + ": " + charlieSharedPost);
        assertEquals("Twitter", mikeSharedPost);
        assertEquals("Facebook", stevenSharedPost);
        assertEquals("Snapchat", charlieSharedPost);
    }

    @Test
    void testIndividualSharingStrategies() {
        //given
        User mike = new Millenials("Mike");

        //when
        String mikeSharedPost = mike.sharePost();
        mike.setSocialPublisher(new SnapchatPublisher());
        mikeSharedPost = mike.sharePost();

        //then
        System.out.println(mike.getUsername() + ": " + mikeSharedPost);
        assertEquals("Snapchat", mikeSharedPost);
    }
}
