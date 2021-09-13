package assignment5;

import java.util.Scanner;

public class Rabbits {
    
    /*
        So, I documented a bit, and my understanding is that this kind of problem, of population growth towards rabbits, can be represented by the fibonacci sequence.
        Firstly, I remembered how it works both theoretically and practically, and then I started applying that knowledge to my case.
        What I get is that:
            - year 1: baby rabbits                                                  - total rabbits: 1
            - year 2: mature babies                                                 - total rabbits: 1
            - year 3: old rabbits + baby rabbits                                    - total rabbits: 2
            - year 4: fossil rabbits + mature rabbits + baby rabbits                - total rabbits: 3 (bc originals die, normally would be 5)
            - year 5: old rabbits + mature rabbits + baby rabbits                   - total rabbits: 4 (second pair dies)
            so on
       My code doesn't fully respect the task, but I tried my best to solve it partially.
       Nonetheless, it calculates correctly the number of rabbits without taking into account the number of years they are active,
       but every year except for infancy and starting with one pair, not multiple as requested.
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int yearsOfLife = 4;

        // Input
        System.out.print("How many years should we let the rabbits multiply? ");
        int yearsOfGrowth = scanner.nextInt();
        System.out.println();

        // Rabbits Fibonacci
        for (int i = 1; i < yearsOfGrowth + 1; i++) {
            int nrOfRabbits = fibonacciRabbitsRecursion(i, yearsOfLife);
            System.out.println(
                    "Year = " + i + " -> " + nrOfRabbits + ((nrOfRabbits == 1) ? " pair of rabbit" : " pairs of rabbits") + " -> " + 2 * nrOfRabbits + " rabbits"
            );
        }
    }

    public static int fibonacciRabbitsRecursion(int n, int x) {
        int Fn;
        if (n < 1) {
            Fn = 0;
        } else if (n == 1) {
            Fn = 1;
        } else if (n < x + 1) {
            Fn = fibonacciRabbitsRecursion(n - 1, x) + fibonacciRabbitsRecursion(n - 2, x);
        } else if (n == x + 1) {
            Fn = fibonacciRabbitsRecursion(n - 1, x) + fibonacciRabbitsRecursion(n - 2, x) - 1;
        } else {
            Fn = fibonacciRabbitsRecursion(n - 1, x) + fibonacciRabbitsRecursion(n - 2, x) - fibonacciRabbitsRecursion(n - x - 1, x);
        }
        return Fn;
    }
}
