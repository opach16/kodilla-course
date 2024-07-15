package com.kodilla.testing.forum.statistics;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ForumStatisticsTestSuite {

    @Mock
    private Statistics statisticsMock;

    @Nested
    @DisplayName("Test methods wtih values \'0\'")
    public class ForumStatisticsTestsDataZero {


        @Test
        public void testNumberOfUsers() {
            //given
            StatisticsCalculator calculator = new StatisticsCalculator(statisticsMock);
            List<String> userNames0 = new ArrayList<>();

            when(statisticsMock.usersNames()).thenReturn(userNames0);

            //when
            calculator.calculateAdvStatistics(statisticsMock);

            //then
            assertEquals(0, calculator.getNumberOfUsers());
        }

        @Test
        public void testNumberOfPosts() {
            //given
            StatisticsCalculator calculator = new StatisticsCalculator(statisticsMock);
            when(statisticsMock.postCount()).thenReturn(0);

            //when
            calculator.calculateAdvStatistics(statisticsMock);

            //then
            assertEquals(0, calculator.getNumberOfPosts());
        }

        @Test
        public void testNumberOfComments() {
            //given
            StatisticsCalculator calculator = new StatisticsCalculator(statisticsMock);
            when(statisticsMock.commentCount()).thenReturn(0);

            //when
            calculator.calculateAdvStatistics(statisticsMock);

            //then
            assertEquals(0, calculator.getNumberOfComments());
        }
    }

    @Nested
    @DisplayName("Test methods with numerical values")
    public class ForumStatisticsTestsData {

        @Test
        public void testNumberOfUsers() {
            //given
            StatisticsCalculator calculator = new StatisticsCalculator(statisticsMock);
            List<String> userNames100 = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                userNames100.add("user" + i);
            }

            when(statisticsMock.usersNames()).thenReturn(userNames100);

            //when
            calculator.calculateAdvStatistics(statisticsMock);

            //then
            assertEquals(100, calculator.getNumberOfUsers());
        }

        @Test
        public void testNumberOfPosts() {
            //given
            StatisticsCalculator calculator = new StatisticsCalculator(statisticsMock);
            when(statisticsMock.postCount()).thenReturn(1000);

            //when
            calculator.calculateAdvStatistics(statisticsMock);

            //then
            assertEquals(1000, calculator.getNumberOfPosts());
        }

        @Test
        public void testMorePostsThanComments() {
            //given
            StatisticsCalculator calculator = new StatisticsCalculator(statisticsMock);
            when(statisticsMock.postCount()).thenReturn(1000);
            when(statisticsMock.commentCount()).thenReturn(10);

            //when
            calculator.calculateAdvStatistics(statisticsMock);

            //then
            assertTrue(calculator.getNumberOfComments() < calculator.getNumberOfPosts());
        }

        @Test
        public void testMoreCommentsThanPosts() {
            //given
            StatisticsCalculator calculator = new StatisticsCalculator(statisticsMock);
            when(statisticsMock.postCount()).thenReturn(10);
            when(statisticsMock.commentCount()).thenReturn(1000);

            //when
            calculator.calculateAdvStatistics(statisticsMock);

            //then
            assertTrue(calculator.getNumberOfComments() > calculator.getNumberOfPosts());
        }
    }

    @Nested
    @DisplayName("Test methods to show values")
    public class ForumStatisticsShowValuesTest {

        @Test
        public void showStatistics() {
            //given
            StatisticsCalculator calculator = new StatisticsCalculator(statisticsMock);
            List<String> userNames = List.of("user1", "user2", "user3");
            when(statisticsMock.usersNames()).thenReturn(userNames);
            when(statisticsMock.postCount()).thenReturn(3);
            when(statisticsMock.commentCount()).thenReturn(30);
            calculator.calculateAdvStatistics(statisticsMock);

            //when
            String result = calculator.showStatistics();

            String expectedString = "Number of users: " + 3 + " " +
                    "Number of posts: " + 3 + " " +
                    "Number of comments: " + 30 + " " +
                    "Average number of posts per user: " + 1.0 + " " +
                    "Average number of comments per user: " + 10.0 + " " +
                    "Average number of comments per post: " + 10.0;

            //then
            assertEquals(expectedString, result);
        }
    }
}