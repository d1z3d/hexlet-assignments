package exercise;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage dbCache) {
        for (Entry<String, String> entry : dbCache.toMap().entrySet()) {
            String key = entry.getValue();
            String value = entry.getKey();
            dbCache.set(key, value);
            dbCache.unset(entry.getKey());
        }
    }
}
// END
