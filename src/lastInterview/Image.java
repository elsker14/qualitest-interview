package lastInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// tzachi.guetta@kaltura.com
// horia.alexandru@kaltura.com

/*

1,2,3,4,5,6,7,8,9
9,8,7,6,5,4,3,2,1

*/
public class Image {
    public static void main(String[] args) {
        List<List<Integer>> originalArr = fillInArr(15);
        print(originalArr);
        System.out.println();

        List<List<Integer>> finalArr = multiplyImage(originalArr);
        print(finalArr);
    }

    public static List<List<Integer>> multiplyImage(List<List<Integer>> pixels)
    {
        int multiplier = 2;
        int l1 = pixels.size() * multiplier;
        int l2 = pixels.get(0).size() * multiplier;

        List<List<Integer>> result = new ArrayList<>(l1);
        for(int i = 0; i < result.size(); i++)
        {
            result.get(i).addAll(new ArrayList<>(l2));
        }

        for(int i = 0; i < l1; i++)
        {
            for(int j = 0; j < l2; j++)
            {
                result.get(i).add(pixels.get(i / 2).get(j / 2));
                result.get(i).add(pixels.get(i / 2).get(j / 2));
            }
        }

        return result;
    }

    public static void print(List<List<Integer>> list)
    {
        for(List<Integer> it: list)
        {
            for(Integer itt: it)
                System.out.print(it);
        }
        System.out.println();
    }

    public static List<List<Integer>> fillInArr(int lineDim)
    {
        List <List<Integer>> result = new ArrayList<>(lineDim);
        int counter = 1;

        for(List<Integer> it: result)
        {
            it.addAll(Arrays.asList(counter,2 * counter,3 * counter,4 * counter,5 * counter,6 * counter,7 * counter,8 * counter,9 * counter,10 * counter));
            counter++;
        }

        return result;
    }
}

