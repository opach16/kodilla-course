package com.kodilla.testing;

public class TestingMain {
    public static void main(String[] args) {
        System.out.println("Moduł 6. Wprowadzenie to testowania oprogramowania");
        String text = "Czy text zawiera samogłoski";
        System.out.println(findVowels(text));
    }

    //Additional exercise
    public static String findVowels(String text) {
        String vowels = "aeiouAEIOU";
        String result = "";
        char[] vowelsArray = text.toCharArray();
        for (int i = 0; i < vowelsArray.length; i++) {
            if (vowels.contains((Character.toString(vowelsArray[i])))) {
                result += (vowelsArray[i]);
            }
        }
        return result;
    }
}