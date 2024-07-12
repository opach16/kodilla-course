package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

@DisplayName("TDD: Forum Test Suite")
public class ForumTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTest() {
        System.out.println("This is the beginning of test.");
    }

    @AfterAll
    public static void afterAllTest() {
        System.out.println("All tests are finished");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Tests for posts")
    public class TestPosts {

        @Test
        void testAddPost() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");

            //When
            forumUser.addPost("mrsmith", "This is the first post");

            //Then
            assertEquals(1, forumUser.getPostsQuantity());
        }

        @Test
        void testGetPost() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost forumPost = new ForumPost("This is the post body", "mrsmith");
            forumUser.addPost(forumPost.getAuthor(), forumPost.getPostBody());

            //When
            ForumPost retrievedPost = forumUser.getPost(0);

            //Then
            assertEquals(forumPost, retrievedPost);
        }

        @Test
        void testRemovePostNotExisting() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost forumPost = new ForumPost("This is the postBody", forumUser.getName());

            //When
            boolean result = forumUser.removePost(forumPost);

            //Then
            assertFalse(result);
        }

        @Test
        void testRemovePost() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost forumPost = new ForumPost("This is the postBody", forumUser.getName());
            forumUser.addPost(forumPost.getAuthor(), forumPost.getPostBody());

            //When
            boolean result = forumUser.removePost(forumPost);

            //Then
            assertTrue(result);
            assertEquals(0, forumUser.getPostsQuantity());
        }
    }

    @Nested
    @DisplayName("Tests for comments")
    public class TestComments {
        @Test
        void testAddComment() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost forumPost = new ForumPost("This is the post body", "mrsmith");

            //When
            forumUser.addComment(forumPost, "mrsmith", "This is the commentBody");

            //Then
            assertEquals(1, forumUser.getCommentsQuantity());
        }

        @Test
        void testGetComment() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost forumPost = new ForumPost("This is the post body", "mrsmith");
            ForumComment forumComment = new ForumComment(forumPost, "mrsmith", "This is the commentBody");
            forumUser.addComment(forumPost, forumComment.getAuthor(), forumComment.getCommentBody());

            //When
            ForumComment retrievedComment = forumUser.getComment(0);

            //Then
            assertEquals(forumComment, retrievedComment);
        }

        @Test
        void testRemoveCommentNotExisting() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost forumPost = new ForumPost("This is the postBody", forumUser.getName());
            ForumComment forumComment = new ForumComment(forumPost, "This is the commentBody", forumUser.getName());

            //When
            boolean result = forumUser.removeComment(forumComment);

            //Then
            assertFalse(result);
        }

        @Test
        void testRemoveComment() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost forumPost = new ForumPost("This is the postBody", forumUser.getName());
            ForumComment forumComment = new ForumComment(forumPost, "This is the commentBody", forumUser.getName());
            forumUser.addComment(forumPost, forumComment.getAuthor(), forumComment.getCommentBody());

            //When
            boolean result = forumUser.removeComment(forumComment);

            //Then
            assertTrue(result);
            assertEquals(0, forumUser.getCommentsQuantity());
        }
    }
}