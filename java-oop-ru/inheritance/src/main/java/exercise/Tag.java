package exercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    private final String tag;
    private final Map<String, String> attributes;
    public Tag(String tag, Map<String, String>  attributes) {
        this.tag = tag;
        this.attributes = new LinkedHashMap<>(attributes);
    }

    public String getTag() {
        return tag;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }
}
// END
