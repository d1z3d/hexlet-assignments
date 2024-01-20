package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> homes, int number) {
        List<String> result = new ArrayList<>();
        if (!homes.isEmpty()) {
            Collections.sort(homes);
            for (int i = 0; i < number; i++) {
                Home home = homes.get(i);
                result.add(home.toString());
            }
        }
        return result;
    }
}
// END
