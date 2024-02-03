package exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private final String text;
    private final List<Tag> tags;

    public PairedTag(String tag, Map<String, String> attributes, String text, List<Tag> tags) {
        super(tag, attributes);
        this.text = text;
        this.tags = new ArrayList<>(tags);
    }

    public String getText() {
        return text;
    }

    public List<Tag> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        if(!tags.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder("<" + getTag() + " ");
            for (String key : getAttributes().keySet()) {
                String value = getAttributes().get(key);
                stringBuilder.append(String.format("%s=\"%s\" ", key, value));
            }
            stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "").append(">");
            for (Tag tag : tags) {
                stringBuilder.append(tag.toString());
            }
            return stringBuilder.append("</").append(getTag()).append(">").toString();
        }

        StringBuilder stringBuilder = new StringBuilder("<" + getTag() + " ");
        for (String key : getAttributes().keySet()) {
            String value = getAttributes().get(key);
            stringBuilder.append(String.format("%s=\"%s\" ", key, value));
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1) + String.format("></%s>", getTag()).replace("><", String.format(">%s<", getText()));
    }
}
// END
