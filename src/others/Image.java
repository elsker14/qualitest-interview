package others;

import java.util.ArrayList;
import java.util.Scanner;

/*
Input:
2 9 3
1 2 3 4 5 6 7 8 9
9 8 7 6 5 4 3 2 1

Other Input:
10 30 2
1 1 1 1 1 1 1 1 1 1 50 50 50 50 50 50 50 50 50 50 150 150 150 150 150 150 150 150 150 150
1 1 1 1 1 1 1 1 1 1 50 50 50 50 50 50 50 50 50 50 150 150 150 150 150 150 150 150 150 150
1 1 1 1 1 1 1 1 1 1 50 50 50 50 50 50 50 50 50 50 150 150 150 150 150 150 150 150 150 150
1 1 1 1 1 1 1 1 1 1 50 50 50 50 50 50 50 50 50 50 150 150 150 150 150 150 150 150 150 150
1 1 1 1 1 1 1 1 1 1 50 50 50 50 50 50 50 50 50 50 150 150 150 150 150 150 150 150 150 150
1 1 1 1 1 1 1 1 1 1 50 50 50 50 50 50 50 50 50 50 150 150 150 150 150 150 150 150 150 150
1 1 1 1 1 1 1 1 1 1 50 50 50 50 50 50 50 50 50 50 150 150 150 150 150 150 150 150 150 150
1 1 1 1 1 1 1 1 1 1 50 50 50 50 50 50 50 50 50 50 150 150 150 150 150 150 150 150 150 150
1 1 1 1 1 1 1 1 1 1 50 50 50 50 50 50 50 50 50 50 150 150 150 150 150 150 150 150 150 150
1 1 1 1 1 1 1 1 1 1 50 50 50 50 50 50 50 50 50 50 150 150 150 150 150 150 150 150 150 150


Output: (this is my thinking before writing the code)
1 1 1 2 2 2 3 3 3 4 4 4 5 5 5 6 6 6 7 7 7 8 8 8 9 9 9
1 1 1 2 2 2 3 3 3 4 4 4 5 5 5 6 6 6 7 7 7 8 8 8 9 9 9
1 1 1 2 2 2 3 3 3 4 4 4 5 5 5 6 6 6 7 7 7 8 8 8 9 9 9
9 9 9 8 8 8 7 7 7 6 6 6 5 5 5 4 4 4 3 3 3 2 2 2 1 1 1
9 9 9 8 8 8 7 7 7 6 6 6 5 5 5 4 4 4 3 3 3 2 2 2 1 1 1
9 9 9 8 8 8 7 7 7 6 6 6 5 5 5 4 4 4 3 3 3 2 2 2 1 1 1

My understanding is that if you want to multiply your image by 2, expanding it until you doubled its form, you ll surround every pixel by a borderline,
meaning each one of them becomes a matrix of 3x3.
Our original pixel is the one in the middle.

This way we re not losing or replacing the colour of a pixel with another, and the image remains the same.
Theoretically, we're doubling the pixel on all 8 directions.
*/
public class Image {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Reading the dimensions
        int lineDim = scan.nextInt();
        int colDim = scan.nextInt();
        int multiplier = scan.nextInt();

        // Creating the matrix
        ArrayList<ArrayList<Integer>> original = createEmptyMatrix(lineDim, colDim);

        // Reading the matrix
        for(int i = 0; i < lineDim; i++)
        {
            for(int j = 0; j < colDim; j++)
            {
                Integer value = scan.nextInt();
                original.get(i).add(value);
            }
        }

        System.out.println("Original matrix: ");
        printMatrix(original, lineDim, colDim);
        System.out.println();

        System.out.println("Resized matrix: ");
        ArrayList<ArrayList<Integer>> resized = resizeMatrix
                (
                original,
                getFactorDeMultiplicare(multiplier) * lineDim,
                getFactorDeMultiplicare(multiplier) * colDim,
                getFactorDeMultiplicare(multiplier)
                );

        printMatrix(resized, getFactorDeMultiplicare(multiplier) * lineDim, getFactorDeMultiplicare(multiplier) * colDim);
    }

    public static ArrayList<ArrayList<Integer>> createEmptyMatrix(int lineDim, int colDim)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(lineDim);

        for(int i = 0; i < lineDim; i++)
        {
            result.add(new ArrayList<>(colDim));
        }
        return result;
    }

    public static void printMatrix(ArrayList<ArrayList<Integer>> result, int lineDim, int colDim)
    {
        for(int i = 0; i < lineDim; i++)
        {
            for(int j = 0; j < colDim; j++)
            {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static int getFactorDeMultiplicare(int multiplier)
    {
        return ((multiplier - 1) * 2 + 1);
    }

    public static ArrayList<ArrayList<Integer>> resizeMatrix(ArrayList<ArrayList<Integer>> original, int lineDim, int colDim, int factorDeMultiplicare)
    {
        int original_i = 0, original_j = 0;
        ArrayList<ArrayList<Integer>> result = createEmptyMatrix(lineDim, colDim);

        for(int i = 0; i < lineDim; i++)
        {
            original_j = 0;
            for(int j = 0; j < colDim; j++)
            {
                if(j > 0 && j % factorDeMultiplicare == 0)
                    original_j++;

                result.get(i).add(original.get(original_i).get(original_j));
            }
            if(i > 0 && (i + 1) % factorDeMultiplicare == 0)
                original_i++;
        }

        return result;
    }
}
