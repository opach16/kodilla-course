package com.kodilla.stream.forumuser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ForumTestSuite {

    private List<ForumUser> forumUsers;
    @Mock
    private Forum forumMock;

    @BeforeEach
    void setUp() {
        forumUsers = List.of(new ForumUser(0001, "user1", 'M', "11/04/1994", 5));
    }

    @DisplayName("Check that the list is not null")
    @Test
    void testGetUserListNotNull() {
        //given
        when(forumMock.getUserList()).thenReturn(forumUsers);
        //when
        List<ForumUser> retrievedList = forumMock.getUserList();

        //then
        assertNotNull(retrievedList);
    }

    @DisplayName("When the list contains only 1 element the method should return list of 1 element")
    @Test
    void testGetUserListSize() {
        //given
        when(forumMock.getUserList()).thenReturn(forumUsers);
        //when
        List<ForumUser> retrievedList = forumMock.getUserList();

        //then
        assertEquals(1, retrievedList.size());
    }

    @DisplayName("Check that the returned list equals to provided list")
    @Test
    void testGetUserList() {
        //given
        List<ForumUser> expectedList = List.of (new ForumUser(0001, "user1", 'M', "11/04/1994", 5));
        when(forumMock.getUserList()).thenReturn(forumUsers);
        //when
        List<ForumUser> retrievedList = forumMock.getUserList();

        //then
        assertEquals(expectedList, retrievedList);
    }
}