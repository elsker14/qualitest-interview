package liveCodingSession;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Word {
    private String word;
    private String codedWord;

    public Word(String word) {
        this.word = word;
        this.codedWord = codeWord(this.word);
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getCodedWord() {
        return codedWord;
    }

    public void setCodedWord(String codedWord) {
        this.codedWord = codedWord;
    }

    public static String codeWord(String word)
    {
        List<Character> listOfChars = new ArrayList<>();
        for(Character it: word.toCharArray())
        {
            listOfChars.add('*');
        }

        return String.valueOf(listOfChars);
    }
}
