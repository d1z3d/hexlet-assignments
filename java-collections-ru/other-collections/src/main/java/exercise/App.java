package exercise;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.function.Function.*;

// BEGIN
public class App {
    public static Map<String, String> genDiff(Map<String, Object> firstDict, Map<String, Object> secondDict) {
        Map<String, String> result = new LinkedHashMap<>();

        result.putAll(secondDict.keySet().stream()
                .filter(key -> !firstDict.containsKey(key))
                .collect(Collectors.toMap(identity(), value -> "added")));

        result.putAll(firstDict.keySet().stream()
                .filter(key -> !secondDict.containsKey(key))
                .collect(Collectors.toMap(identity(), value -> "deleted")));

        result.putAll(firstDict.entrySet().stream()
                .filter(entry -> secondDict.containsKey(entry.getKey()) &&
                        secondDict.get(entry.getKey()).equals(entry.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, value -> "unchanged")));

        result.putAll(firstDict.entrySet().stream()
                .filter(entry -> secondDict.containsKey(entry.getKey()) &&
                        !secondDict.get(entry.getKey()).equals(entry.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, value -> "changed")));


        return result;
    }
}
//END
