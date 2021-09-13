package assignment3;

import java.util.*;

public class Duplicates {


    public static void main(String[] args) {
        // Method 1
        /* One way of filtering the duplicates is by moving all elements in a Set, who has a special property of having only unique elements */
        /* After that we can move back in a list */
        ArrayList<Integer> to_be_used = new ArrayList<>(Arrays.asList(1, 3, 67, 1, 62, 3, 5, 1 ,3, 13));
        ArrayList<Integer> to_be_used_unique = deleteDuplicates(to_be_used);

        for(Integer it: to_be_used_unique)
            System.out.print(it + " ");
        System.out.println();

        // Method 2
        /* The assignment specifies that my list has a variety of data types (integer, float, string, boolean), but that is possible in Python, not int Java */
        /* I will attempt to recreate the situation in DuplicatesClass.java where I will create a List of objects of different types, using more constructors */
        /* One thing that is still opposing me, is that if I want to print the list as it is, it won't show the all of my elements, since they are objects of different data types */
        /* That's why I have to filter using getter method for each specific type, so I avoid having null values among my list*/

        ArrayList<DuplicatesClass> to_be_used_complex = DuplicatesClass.createArrayOfDifferentElements();
        ArrayList<Integer> to_be_used_onlyIntegers = new ArrayList<>();

        for(DuplicatesClass it: to_be_used_complex)
            if(it.getElementInt() != null) {
                to_be_used_onlyIntegers.add(it.getElementInt());
            }

        ArrayList<Integer> to_be_used_filteredNotNull = deleteDuplicates(to_be_used_onlyIntegers);
        for(Integer it: to_be_used_filteredNotNull)
            System.out.print(it + " ");
    }

    public static <T> ArrayList<T> deleteDuplicates(ArrayList<T> list)
    {
        Set<T> unique_list = new LinkedHashSet<>(list);
        list.clear();
        list.addAll(unique_list);
        return list;
    }
}
