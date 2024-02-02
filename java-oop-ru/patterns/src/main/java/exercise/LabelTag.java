package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private final String label;
    private final TagInterface tagInterface;

    public LabelTag(String label, TagInterface tagInterface) {
        this.label = label;
        this.tagInterface = tagInterface;
    }

    @Override
    public String render() {
        return String.format("<label>%s%s</label>", label, tagInterface.render());
    }
}
// END
