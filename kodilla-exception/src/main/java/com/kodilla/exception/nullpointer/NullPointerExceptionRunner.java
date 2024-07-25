package com.kodilla.exception.nullpointer;

public class NullPointerExceptionRunner {

    public static void main(String[] args) {
        User user = null;
        MessageSender messageSender = new MessageSender();
        try {
            messageSender.sendMessage(user, "Hello!");
        } catch (MessageNotSentException e) {
            System.out.println(e.getMessage());
            System.out.println("Message was not sent, but the program still running");
        }
        System.out.println("Proccessing other logic!");
    }
}
