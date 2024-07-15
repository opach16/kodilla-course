package com.kodilla.testing.forum.statistics;

public class StatisticsCalculator {

    private Statistics statistics;
    private int numberOfUsers;
    private int numberOfPosts;
    private int numberOfComments;
    private double averageNumberOfPostsPerUser;
    private double averageNumberOfCommentsPerUser;
    private double averageNumberOfCommentsPerPost;

    public StatisticsCalculator(Statistics statistics) {
        this.statistics = statistics;
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public void setNumberOfUsers(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public void setNumberOfPosts(int numberOfPosts) {
        this.numberOfPosts = numberOfPosts;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(int numberOfComments) {
        this.numberOfComments = numberOfComments;
    }

    public double getAverageNumberOfPostsPerUser() {
        return averageNumberOfPostsPerUser;
    }

    public void setAverageNumberOfPostsPerUser(double averageNumberOfPostsPerUser) {
        this.averageNumberOfPostsPerUser = averageNumberOfPostsPerUser;
    }

    public double getAverageNumberOfCommentsPerUser() {
        return averageNumberOfCommentsPerUser;
    }

    public void setAverageNumberOfCommentsPerUser(double averageNumberOfCommentsPerUser) {
        this.averageNumberOfCommentsPerUser = averageNumberOfCommentsPerUser;
    }

    public double getAverageNumberOfCommentsPerPost() {
        return averageNumberOfCommentsPerPost;
    }

    public void setAverageNumberOfCommentsPerPost(double averageNumberOfCommentsPerPost) {
        this.averageNumberOfCommentsPerPost = averageNumberOfCommentsPerPost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatisticsCalculator that = (StatisticsCalculator) o;
        return numberOfUsers == that.numberOfUsers && numberOfPosts == that.numberOfPosts && numberOfComments == that.numberOfComments && Double.compare(averageNumberOfPostsPerUser, that.averageNumberOfPostsPerUser) == 0 && Double.compare(averageNumberOfCommentsPerUser, that.averageNumberOfCommentsPerUser) == 0 && Double.compare(averageNumberOfCommentsPerPost, that.averageNumberOfCommentsPerPost) == 0;
    }

    @Override
    public int hashCode() {
        int result = numberOfUsers;
        result = 31 * result + numberOfPosts;
        result = 31 * result + numberOfComments;
        result = 31 * result + Double.hashCode(averageNumberOfPostsPerUser);
        result = 31 * result + Double.hashCode(averageNumberOfCommentsPerUser);
        result = 31 * result + Double.hashCode(averageNumberOfCommentsPerPost);
        return result;
    }

    public void calculateAdvStatistics(Statistics statistics) {
        numberOfUsers = statistics.usersNames().size();
        numberOfPosts = statistics.postCount();
        numberOfComments = statistics.commentCount();
        if(numberOfUsers != 0) {
            averageNumberOfPostsPerUser = numberOfPosts / numberOfUsers;
            averageNumberOfCommentsPerUser = numberOfComments / numberOfUsers;
        }
        if (numberOfPosts != 0) {
            averageNumberOfCommentsPerPost = numberOfComments / numberOfPosts;
        }
    }

    public String showStatistics() {
        return "Number of users: " + numberOfUsers + " " +
                "Number of posts: " + numberOfPosts + " " +
                "Number of comments: " + numberOfComments + " " +
                "Average number of posts per user: " + averageNumberOfPostsPerUser + " " +
                "Average number of comments per user: " + averageNumberOfCommentsPerUser + " " +
                "Average number of comments per post: " + averageNumberOfCommentsPerPost;
    }
}