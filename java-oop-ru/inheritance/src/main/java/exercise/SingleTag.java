package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    public SingleTag(String tag, Map<String, String> attributes) {
        super(tag, attributes);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("<" + getTag() + " ");
        for (String key : getAttributes().keySet()) {
            String value = getAttributes().get(key);
            stringBuilder.append(String.format("%s=\"%s\" ", key, value));
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1) + ">";
    }
}
// END
