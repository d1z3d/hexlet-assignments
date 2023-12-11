package exercise;

import java.util.*;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> expression) {
        ArrayList<Map<String, String>> result = new ArrayList<>();
        ArrayList<Boolean> isBookEquals = new ArrayList<>();

        for (Map<String, String> book : books) {
            for (Map.Entry<String, String> entry : book.entrySet()) {
                for (Map.Entry<String, String> where : expression.entrySet()) {

                    if (entry.getKey().equalsIgnoreCase(where.getKey())) {
                        if (entry.getValue().equalsIgnoreCase(where.getValue())) {
                            isBookEquals.add(true);
                        } else {
                            isBookEquals.add(false);
                        }
                    }

                }
            }
            if (!isBookEquals.isEmpty() && !isBookEquals.contains(false)) {
                result.add(book);
            }
            isBookEquals.clear();
        }

        return result;
    }
}
//END
