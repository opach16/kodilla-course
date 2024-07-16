package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {

    public static void main(String[] args) {

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("An example of a text to decorate", (text) -> "ABC " + text + " ABC");
        poemBeautifier.beautify("An example of a text to decorate", (text) -> text.toUpperCase());
        poemBeautifier.beautify("An example of a text to decorate", (text) -> text.toLowerCase().replaceAll(" ", "-"));
        poemBeautifier.beautify("An example of a text to decorate", (text) ->
        {
            String result = "";
            boolean switchCase = false;

            for (Character c : text.toCharArray()) {
                if (Character.isLetter(c)) {
                    if (switchCase) result += Character.toLowerCase(c);
                    else result += Character.toUpperCase(c);
                    switchCase = !switchCase;
                } else result += c;
            }
            return result;
        });
    }
}