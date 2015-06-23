import java.util.ArrayList;

public class ProgNode implements Node {

    ArrayList<Node> children;

    public ProgNode() {
        children = new ArrayList<Node>();
    }

    public void add(Node node) {
        children.add(node);
    }

    public ArrayList<Node> children() {
        return children;
    }

    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}