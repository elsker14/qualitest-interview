package assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Reverse {

    public static void main(String[] args) {
        String text = "Automation";
        String reversedText = reverseTextSB(text);
        String backToOriginalText = reverseTextClassy(reversedText);

        System.out.println(text);
        System.out.println(reversedText);
        System.out.println(backToOriginalText);
    }
    // Method 1: using a special class that enhances you to modify how you want a string
    private static String reverseTextSB(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(text);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    // Method 2: classy approach by adding backwards the letters of the string in a list and rebuilding the word
    private static String reverseTextClassy(String text) {
        List<Character> arr = new ArrayList<>();

        for(Character ch: text.toCharArray())
        {
            arr.add(ch);
        }
        Collections.reverse(arr);

        return arr.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
