package com.kodilla.stream.mirror;

public class MirrorString {

    public String turn(String text) {
        char[] chars;
        String result = "";
        if (text != null && !text.isEmpty()) {
            chars = text.toCharArray();
            for (int i = chars.length - 1; i >= 0; i--) {
                result += chars[i];
            }
        }
        return result;
    }
}