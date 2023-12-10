package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {

    public static void main(String[] args) {
        String sentence1 = "word text dog apple word apple word";
        Map<String, Integer> actual1 = getWordCount(sentence1);
        String a = toString(actual1);
        Map<String, Integer> expected1 = new HashMap<>();
        expected1.put("word", 3);
        expected1.put("apple", 2);
        expected1.put("text", 1);
        expected1.put("dog", 1);

        System.out.println(a);
    }
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> map = new HashMap<>();

        if (sentence.isEmpty()) {
            return map;
        }

        String[] sentenceByWords = sentence.split(" ");

        for (String word : sentenceByWords) {
            Integer count = map.getOrDefault(word, 0) + 1;

            map.put(word, count);
        }

        return map;
    }

    public static String toString(Map<String, Integer> map) {
        if (map.isEmpty()) {
            return "{}";
        }

        String result = "{\n";

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result = result.concat(String.format("  %s: %d\n", entry.getKey(), entry.getValue()));
        }

        result = result.concat("}");

        return result;
    }
}
//END
