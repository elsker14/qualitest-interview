package liveCodingSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Lists
        List<Word> databaseWords = createDatabase();
        List<Player> players = new ArrayList<>();

        // Insert nr of players
        Scanner scan = new Scanner(System.in);
        System.out.print("Insert number of players: ");
        int nrOfPlayers = scan.nextInt();

        // Initializing players database
        System.out.println();
        for(int i = 0; i < nrOfPlayers; i++)
        {
            System.out.print("Insert players names: ");
            String name = scan.next();

            players.add(new Player(name));
        }

        // Play game
        for(Player it: players)
        {
            playGame(it, databaseWords);
        }
    }

    public static List<Word> createDatabase()
    {
        List<Word> result = new ArrayList<>();

        result.add(new Word("caine"));
        result.add(new Word("pisica"));
        result.add(new Word("animal"));
        result.add(new Word("perete"));
        result.add(new Word("tavan"));

        return result;
    }

    public static String fillStringWithLetter(char ch, String word, String codedWord)
    {
        for(int i = 0; i < word.length(); i++)
        {
            if(ch == word.charAt(i))
            {
                char[] list = codedWord.toCharArray();
                list[i] = ch;
                String result = String.valueOf(list);
                return result;
            }
        }
        return "";
    }

    public static boolean checkIfWordIsDecoded(String codedWord)
    {
        return codedWord.contains("*");
    }

    public static void playGame(Player player, List <Word> listOfWords)
    {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int indexOfWord = rand.nextInt(listOfWords.size()) + 1;

        String chosenCodedWord = listOfWords.get(indexOfWord).getCodedWord();
        String chosenOriginalWord = listOfWords.get(indexOfWord).getWord();

        while(player.getLives() > 0 || checkIfWordIsDecoded(chosenCodedWord))
        {
            System.out.println("Your word is: " + chosenCodedWord);
            System.out.print("Insert letter: ");
            String insertedCh = scan.next();
            System.out.println();

            if(!chosenOriginalWord.contains(insertedCh))
            {
                player.setLives(player.getLives() - 1);
                System.out.println("Wrong! You have " + player.getLives() + " lives");
            }
            else
            {
                chosenCodedWord = fillStringWithLetter(insertedCh.charAt(0), chosenOriginalWord, chosenCodedWord);
                System.out.println("Correct!");
            }
        }
    }
}
