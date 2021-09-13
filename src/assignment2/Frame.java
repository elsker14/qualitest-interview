package assignment2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Frame {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World", "in", "an", "awesome", "frame", "from", "Guadalajara");

        printRectangularFrame(words);
    }

    private static void printRectangularFrame(List<String> words) {
        int longestSize = getMaxSizeOfElementFromStringList(words);
        String starLineJoin = String.join("", Collections.nCopies(longestSize + 4, String.valueOf('*')));
        // String starLineGenerate = Stream.generate(() -> String.valueOf('*')).limit(longestSize + 4).collect(Collectors.joining());

        /* Creating the frame */
        int lineSize = words.toArray().length + 2;
        int columnSize = longestSize + 4;
        char[][] matrix = new char[lineSize][columnSize];

        matrix[0] = starLineJoin.toCharArray();
        for (int i = 1; i < lineSize - 1; i++) {
            String temp = "* " + words.get(i - 1);
            temp = addSpaces(temp, columnSize);

            matrix[i] = temp.toCharArray();
        }
        matrix[lineSize - 1] = starLineJoin.toCharArray();

        /* Print Matrix */
        printMatrix(matrix, lineSize, columnSize);
    }

    private static String addSpaces(String temp, int columnSize) {
        int size = columnSize - temp.length() - 1;
        StringBuilder tempBuilder = new StringBuilder(temp);

        for(int i = 0; i < size; i++)
            tempBuilder.append(" ");
        tempBuilder.append("*");

        temp = tempBuilder.toString();
        return temp;
    }

    private static int getMaxSizeOfElementFromStringList(List<String> words) {
        int longestSize = 0;
        for (String it : words)
            if (it.length() > longestSize) {
                longestSize = it.length();
            }
        return longestSize;
    }

    private static void printMatrix(char[][] matrix, int lineSize, int columnSize)
    {
        for (int i = 0; i < lineSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
