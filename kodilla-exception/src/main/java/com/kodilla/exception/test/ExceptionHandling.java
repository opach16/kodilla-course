package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {

        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            System.out.println(secondChallenge.probablyIWillThrowException(2.9, 2));
        } catch (Exception e) {
            System.out.println("Values are out of bounds");
        }
    }
}