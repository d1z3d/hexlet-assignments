package exercise;

import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static void main(String[] args) {
        System.out.println(scrabble("thlxertwq", "hexlet"));
    }
    public static boolean scrabble(String chars, String word) {
        boolean isPossible = true;

        List<Character> charsAsList = new ArrayList<>();
        List<Character> wordAsList = new ArrayList<>();

        for (char ch : chars.toLowerCase().toCharArray()) {
            charsAsList.add(ch);
        }

        for (char ch : word.toLowerCase().toCharArray()) {
            wordAsList.add(ch);
        }

        for (Character symbolFromWord : wordAsList) {
            if (!charsAsList.contains(symbolFromWord)) {
                isPossible = false;
            } else {
                charsAsList.remove(symbolFromWord);
            }
        }

        //mock
        return isPossible;
    }
}
//END
